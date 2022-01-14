const WebSocket = require('ws');
const SEND = require('./send');

(async () => {
    const endpoint = "ws://localhost:9222/devtools/page/70C75025F244036BFA87AB036E60BDF2";
    const ws = new WebSocket(endpoint, {perMessageDeflate: false});
    await new Promise(resolve => ws.once('open', resolve));
    console.log('connected');
    ws.once('message', msg => console.log(msg));

    console.log('Sending Target.setDiscoverTargets');
    ws.send(JSON.stringify({
        id: 1,
        method: 'Target.setDiscoverTargets',
        params: {
            discover: true
        }
    }));

    const sessionId = (await SEND(ws, {
        id: 2,
        method: 'Target.attachToTarget',
        params: {
            // targetId got from Postman
            targetId: '70C75025F244036BFA87AB036E60BDF2',
            flatten: true
        }
    })).result.sessionId;

    console.log('SessionId', sessionId);

    /*await SEND(ws, {
        sessionId,
        id: 1,
        method: 'Page.navigate',
        params: {
            url: 'https://google.com'
        }
    });*/

    await SEND(ws, {
        sessionId,
        id: 1,
        method: 'Page.reload'
    });

    await new Promise(resolve => setTimeout(resolve, 3000));

    const documentId = (await SEND(ws, {
        sessionId,
        id: 2,
        method: 'DOM.getDocument',
        params: {

        }
    })).result.root.nodeId;

    console.log('Document ID', documentId);

    const nodeIds = (await SEND(ws, {
        sessionId,
        id: 3,
        method: 'DOM.querySelectorAll',
        params: {
            nodeId: documentId,
            selector: "div.price-template-price-block"
        }
    })).result.nodeIds;

    console.log('Node IDs', nodeIds);

    const html = (await SEND(ws, {
        sessionId,
        id: 4,
        method: 'DOM.getOuterHTML',
        params: {
            nodeId: nodeIds[0]
        }
    })).result.outerHTML;

    console.log('HTML', html);
})();