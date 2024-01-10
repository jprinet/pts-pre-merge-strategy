# Predictive Test Selection - pre-merge strategy

This repository illustrates how [Develocity Predictive Selection feature](https://docs.gradle.com/enterprise/predictive-test-selection/) can be implemented with a pre-merge strategy.

## Implementation

### Main Build

Builds of the main branch happen without PTS enabled.

See the [workflow file](./.github/workflows/main-build.yml) for more details.

### PR Build

PR builds happen with PTS enabled, but a required [status check](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/collaborating-on-repositories-with-code-quality-features/about-status-checks) 
is added to the PR to ensure all tests will be executed before merging.

In details, the PR builds select [relevant tests](https://docs.gradle.com/enterprise/predictive-test-selection/#relevant-vs-remaining-tests) and when the PR is ready to be merged an extra build can be triggered manually to run the remaining tests.
The current implementation triggers the extra build by commenting the PR with the message "Build with remaining tests".

Merging the PR is only possible once the extra check has passed.

See the [workflow file](./.github/workflows/pr-build.yml) for more details.

## Characteristics

### Pros
- No risk

### Cons
- One extra build to run before merge
- Implementation requires an extra CI workflow