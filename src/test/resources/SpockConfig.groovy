import test.PeopleAPI.PeopleTests

spockReports {
    set 'com.athaydes.spockframework.report.outputDir': 'target/spock-reports'
}

runner {
    def targetedCase = System.properties['testCase']
    switch (targetedCase) {
        case 'Test':
            include PeopleTests

            break
    }
}