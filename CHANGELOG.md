## [3.0.2](https://github.com/DanySK/gradle-cpd-plugin/compare/3.0.1...3.0.2) (2024-11-20)

### Dependency updates

* **core-deps:** update dependency gradle to v8.11.1 ([#37](https://github.com/DanySK/gradle-cpd-plugin/issues/37)) ([fd6ad4f](https://github.com/DanySK/gradle-cpd-plugin/commit/fd6ad4fc795e365ca1317cde3c16d71ee411cb11))

## [3.0.1](https://github.com/DanySK/gradle-cpd-plugin/compare/3.0.0...3.0.1) (2024-11-20)

### Dependency updates

* **core-deps:** update dependency gradle to v8.11 ([#22](https://github.com/DanySK/gradle-cpd-plugin/issues/22)) ([a3eee5a](https://github.com/DanySK/gradle-cpd-plugin/commit/a3eee5ab34cedc98561b51d9da5475efcd4423d2))

### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v3.5.20 ([#35](https://github.com/DanySK/gradle-cpd-plugin/issues/35)) ([0596dbc](https://github.com/DanySK/gradle-cpd-plugin/commit/0596dbcbb6b8157bf0765c265fbcc1a06e0f1bce))
* disable dry-deployments on Maven Central to relieve OSSRH ([#36](https://github.com/DanySK/gradle-cpd-plugin/issues/36)) ([aba6741](https://github.com/DanySK/gradle-cpd-plugin/commit/aba67412943bf2a3717be8904065baf39ed5489f))

## [3.0.0](https://github.com/DanySK/gradle-cpd-plugin/compare/2.0.1...3.0.0) (2024-11-19)

### ⚠ BREAKING CHANGES

* pull from upstream

### Features

* pull from upstream ([634510c](https://github.com/DanySK/gradle-cpd-plugin/commit/634510cdc992862d18efa723e52a283533145a08))

### Bug Fixes

* add @Nonnull annotations ([f900d04](https://github.com/DanySK/gradle-cpd-plugin/commit/f900d0422465923284b4b2c0b65f472d06ec9f03))
* add `@Nonnull` annotations ([2129e18](https://github.com/DanySK/gradle-cpd-plugin/commit/2129e189c884dda5fb5fd257b16c455818525d21))

### Documentation

* remove reference to non-found symbol ([c0f1aae](https://github.com/DanySK/gradle-cpd-plugin/commit/c0f1aaec55c437a3edaf969c38325ae068fed16c))
* remove unused anchor ([9220a77](https://github.com/DanySK/gradle-cpd-plugin/commit/9220a77548cf8c423e9718cffb581e16589b35bf))
* remove unused anchor ([8c73079](https://github.com/DanySK/gradle-cpd-plugin/commit/8c730790c5460f68a5b2ed09189d8de3702c046c))

### Build and continuous integration

* do not cancel in-progress builds ([471f26d](https://github.com/DanySK/gradle-cpd-plugin/commit/471f26d61ca2cd9ff27d9a20fb5dca4f5bea7728))
* run build jobs concurrently ([49843e7](https://github.com/DanySK/gradle-cpd-plugin/commit/49843e7429d8c3cf5ba03fc531c387cc10a61625))

### Style improvements

* avoid raw types ([dd56190](https://github.com/DanySK/gradle-cpd-plugin/commit/dd56190d327c88c0c7a4ac2318c542898c96f854))
* avoid raw types ([f0b0e6b](https://github.com/DanySK/gradle-cpd-plugin/commit/f0b0e6bae80054733283b1a5b9407f0546654702))
* make `addReport` return void ([64de254](https://github.com/DanySK/gradle-cpd-plugin/commit/64de254199fd882eb51eaeaf6ec92a54f02e952f))
* replace statement lambda with expression lambda ([a748162](https://github.com/DanySK/gradle-cpd-plugin/commit/a748162df0a9ee7e8b8ab2e2a1a70fa7d1151439))

## [2.0.1](https://github.com/DanySK/gradle-cpd-plugin/compare/2.0.0...2.0.1) (2024-11-19)

### Dependency updates

* **core-deps:** update dependency net.sourceforge.pmd:pmd-dist to v7.7.0 ([#34](https://github.com/DanySK/gradle-cpd-plugin/issues/34)) ([e953996](https://github.com/DanySK/gradle-cpd-plugin/commit/e953996d08160e21bcd2fc443e07ab873f3f1b66))

## [2.0.0](https://github.com/DanySK/gradle-cpd-plugin/compare/1.1.0...2.0.0) (2024-11-19)

### ⚠ BREAKING CHANGES

* add support for PMD 7.3.0

### Features

* add support for PMD 7.3.0 ([54a6242](https://github.com/DanySK/gradle-cpd-plugin/commit/54a6242a451213430ee1be4a22f93ef631cb59dc))

### Dependency updates

* **core-deps:** update dependency net.sourceforge.pmd:pmd-dist to v7.6.0 ([#33](https://github.com/DanySK/gradle-cpd-plugin/issues/33)) ([a7cd936](https://github.com/DanySK/gradle-cpd-plugin/commit/a7cd93633017497fd8bbad69f2eea2efeb7d22ab))

### Documentation

* remove readme columns with versions not making sense anymore, document failOnErrors and failOnViolations ([484720a](https://github.com/DanySK/gradle-cpd-plugin/commit/484720ac6d12b097f60c25a79d0482c7551bc9c0))

### Tests

* avoid calling the deprecated Gradle `getBuildDir()` API ([773cd95](https://github.com/DanySK/gradle-cpd-plugin/commit/773cd953e570bed3c21a0b8c6a29d58586cc3c4e))

## [1.1.0](https://github.com/DanySK/gradle-cpd-plugin/compare/1.0.4...1.1.0) (2024-11-19)

### Features

* lock the version of PMD and use it throughout the project ([993abb0](https://github.com/DanySK/gradle-cpd-plugin/commit/993abb0ee57eb4f18ac1e7407830b4dfd72ca127))

### Bug Fixes

* annotate with @Nonnull methods and parameters annotated as @Nonnull in superclasses ([1addb24](https://github.com/DanySK/gradle-cpd-plugin/commit/1addb24ebdd4958c896432eb4b8f5258d17aa4bd))

### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v3.5.18 ([#29](https://github.com/DanySK/gradle-cpd-plugin/issues/29)) ([877a961](https://github.com/DanySK/gradle-cpd-plugin/commit/877a961a9974a9849608b98e542eb1ef3f358324))
* remove unused variable ([abf6990](https://github.com/DanySK/gradle-cpd-plugin/commit/abf699049d8aa10d0e6256b0634275353aad0a3a))

## [1.0.4](https://github.com/DanySK/gradle-cpd-plugin/compare/1.0.3...1.0.4) (2024-11-18)

### Dependency updates

* **core-deps:** update dependency gradle to v8.10.2 ([#21](https://github.com/DanySK/gradle-cpd-plugin/issues/21)) ([77d50dc](https://github.com/DanySK/gradle-cpd-plugin/commit/77d50dc8a29e86eaa557610dcd5e32cf3d878fff))

## [1.0.3](https://github.com/DanySK/gradle-cpd-plugin/compare/1.0.2...1.0.3) (2024-11-18)

### Dependency updates

* **core-deps:** update gradle to 8.0 ([19d3d6b](https://github.com/DanySK/gradle-cpd-plugin/commit/19d3d6b9aabb29dea6adf052a1c3a576443c0a60))
* **deps:** update dependency com.google.guava:guava to v33.3.1-jre ([#6](https://github.com/DanySK/gradle-cpd-plugin/issues/6)) ([4bdad32](https://github.com/DanySK/gradle-cpd-plugin/commit/4bdad32f41dc72fb6c13a8bfc49c6b13a8088502))
* **deps:** update junit5 monorepo to v5.11.3 ([#9](https://github.com/DanySK/gradle-cpd-plugin/issues/9)) ([4d22d4e](https://github.com/DanySK/gradle-cpd-plugin/commit/4d22d4e16eb4438b4c8c3e6c37584043ac8403cc))
* **deps:** update mockito monorepo to v5.14.2 ([#10](https://github.com/DanySK/gradle-cpd-plugin/issues/10)) ([75a48af](https://github.com/DanySK/gradle-cpd-plugin/commit/75a48af40f08b5272791145181c5428a150d2cc8))
* **deps:** update plugin multijvmtesting to v1.3.1 ([#16](https://github.com/DanySK/gradle-cpd-plugin/issues/16)) ([4bfce48](https://github.com/DanySK/gradle-cpd-plugin/commit/4bfce481e3673f830788f296adb4eef9215522aa))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.14 ([#18](https://github.com/DanySK/gradle-cpd-plugin/issues/18)) ([a27f663](https://github.com/DanySK/gradle-cpd-plugin/commit/a27f663f53cae7fd97bb99c0ed9749d67d390fa9))
* **deps:** update plugin publishoncentral to v5.1.10 ([#17](https://github.com/DanySK/gradle-cpd-plugin/issues/17)) ([5f7eafb](https://github.com/DanySK/gradle-cpd-plugin/commit/5f7eafb8bfc8d8f05e975246e2a1e9d3481a6f01))

### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v3.5.17 ([#15](https://github.com/DanySK/gradle-cpd-plugin/issues/15)) ([8bae24c](https://github.com/DanySK/gradle-cpd-plugin/commit/8bae24cf52e9f1b1da9c0603cfd1f97338edab81))

## [1.0.2](https://github.com/DanySK/gradle-cpd-plugin/compare/1.0.1...1.0.2) (2024-11-15)

### Dependency updates

* **core-deps:** update dependency net.sourceforge.pmd:pmd-dist to v7.7.0 ([#7](https://github.com/DanySK/gradle-cpd-plugin/issues/7)) ([9e42282](https://github.com/DanySK/gradle-cpd-plugin/commit/9e422823758b7ff8bcb6094955f6fc8947d6d7d8))

## [1.0.1](https://github.com/DanySK/gradle-cpd-plugin/compare/1.0.0...1.0.1) (2024-11-15)

### Dependency updates

* **core-deps:** update dependency gradle to v7.6.4 ([#13](https://github.com/DanySK/gradle-cpd-plugin/issues/13)) ([29d3bce](https://github.com/DanySK/gradle-cpd-plugin/commit/29d3bce9bcac6a9548d7a75ed52727aca9c02ca1))
* **deps:** update dependency org.assertj:assertj-core to v3.26.3 ([5bb5077](https://github.com/DanySK/gradle-cpd-plugin/commit/5bb5077e13c18d13e2ced1c678adaeb3f4080a07))
* **deps:** update junit5 monorepo to v5.10.5 ([#3](https://github.com/DanySK/gradle-cpd-plugin/issues/3)) ([d4830f1](https://github.com/DanySK/gradle-cpd-plugin/commit/d4830f109aa4e48d9f1224f10dafccdeb0dd157d))
* **deps:** update plugin com.gradle.develocity to v3.18.2 ([97dc6ad](https://github.com/DanySK/gradle-cpd-plugin/commit/97dc6adb83c322fe09c94ce61f346bb21d5a7ca2))

### Build and continuous integration

* add distributionSha256Sum ([7d4ce1f](https://github.com/DanySK/gradle-cpd-plugin/commit/7d4ce1f2353e6ea837aef9cdee2926ba560ca16e))
* always publish the build scan ([1d33a85](https://github.com/DanySK/gradle-cpd-plugin/commit/1d33a85acdfb4ee69d40ef8937e2e2ab55cdd6aa))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3.5.16 ([2364401](https://github.com/DanySK/gradle-cpd-plugin/commit/23644014e091cc7ebe26b194d7060bb1eee32b83))
* regenerate `gradlew.bat` ([a056273](https://github.com/DanySK/gradle-cpd-plugin/commit/a056273a40eaf517d1c8d6c40788c5eeae2eed10))
* **release:** do not retry to release on failure ([c5c63c5](https://github.com/DanySK/gradle-cpd-plugin/commit/c5c63c5599aab665b8213715a71c130297fcbd24))
* **release:** trigger a patch on PMD updates ([845835a](https://github.com/DanySK/gradle-cpd-plugin/commit/845835a07ee2fa54a33a2e314a41196d75f4bd10))
* **renovate:**  include forks ([6d23c9e](https://github.com/DanySK/gradle-cpd-plugin/commit/6d23c9e564a9c939e5d26ccf4d841768b90b91d7))

## 1.0.0 (2024-11-15)

### ⚠ BREAKING CHANGES

* switch to a better build (#1)

### Build and continuous integration

* add codecov token ([dac848c](https://github.com/DanySK/gradle-cpd-plugin/commit/dac848ce84bc708136299dda746fcdb284801ea9))
* create a new publication as the default one gets mysteriously corrupted ([c9d5fd6](https://github.com/DanySK/gradle-cpd-plugin/commit/c9d5fd63a9a01b4539fdba3051ecd0903d9fdd0b))
* depend on the Gradle API ([f23dbef](https://github.com/DanySK/gradle-cpd-plugin/commit/f23dbefc80295717a729a4080ea1f761871433b4))
* enable release on this fork ([b07b9d9](https://github.com/DanySK/gradle-cpd-plugin/commit/b07b9d99000f42d8bb8f7bbd174fff39e69626a2))
* fix task name ([6f017a9](https://github.com/DanySK/gradle-cpd-plugin/commit/6f017a984457d5e23eab046bfcaedd03dbec19ca))
* switch to a better build ([#1](https://github.com/DanySK/gradle-cpd-plugin/issues/1)) ([377d024](https://github.com/DanySK/gradle-cpd-plugin/commit/377d02426a02bc393f5df87487fdc735e3e02642))
