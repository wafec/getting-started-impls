from mitmproxy import http
from mitmproxy import ctx


def request(flow: http.HTTPFlow) -> None:
    ctx.log.info(f"pretty_host = {flow.request.pretty_host}")
    if flow.request.pretty_host == "genomics-web-automation.cloud.pcftest.com":
        flow.request.port = 80
        flow.request.host = "161.85.54.68"
        flow.request.scheme = 'http'
