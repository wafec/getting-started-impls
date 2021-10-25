# Experiment
This folder was created to investigate the problem of pagination performance with SQL.

Pagination is a common practice for a huge amount of data that shall be displayed to the user
but cannot be shown at once. However, to make that possible we need two I/O operations, one for
querying the total count for a specific query, and another one to get the results and the 
corresponding page or window.

Depending on the query complexity, this time to process the results for both cases might
increase and be a problem for the application performance.

# Conclusions
Ongoing experiment