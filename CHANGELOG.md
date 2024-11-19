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