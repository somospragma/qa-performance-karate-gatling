var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "190",
        "ok": "190",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "412",
        "ok": "412",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1483",
        "ok": "1483",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "502",
        "ok": "502",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "226",
        "ok": "226",
        "ko": "-"
    },
    "percentiles1": {
        "total": "447",
        "ok": "447",
        "ko": "-"
    },
    "percentiles2": {
        "total": "458",
        "ok": "458",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1046",
        "ok": "1046",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1459",
        "ok": "1459",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 180,
    "percentage": 95
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 10,
    "percentage": 5
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "8.261",
        "ok": "8.261",
        "ko": "-"
    }
},
contents: {
"req_post--api-login-7b2a4": {
        type: "REQUEST",
        name: "POST /api/login",
path: "POST /api/login",
pathFormatted: "req_post--api-login-7b2a4",
stats: {
    "name": "POST /api/login",
    "numberOfRequests": {
        "total": "190",
        "ok": "190",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "412",
        "ok": "412",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1483",
        "ok": "1483",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "502",
        "ok": "502",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "226",
        "ok": "226",
        "ko": "-"
    },
    "percentiles1": {
        "total": "447",
        "ok": "447",
        "ko": "-"
    },
    "percentiles2": {
        "total": "458",
        "ok": "458",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1046",
        "ok": "1046",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1459",
        "ok": "1459",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 180,
    "percentage": 95
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 10,
    "percentage": 5
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "8.261",
        "ok": "8.261",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
