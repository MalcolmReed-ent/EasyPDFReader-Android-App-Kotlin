# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [1.1.0] - 2023-09-15

### Added
- Persistent folder selection using SharedPreferences
- FloatingActionButton to allow users to change the selected folder at any time
- Jetifier support for backward compatibility with Support libraries
- Performance optimization flags in gradle.properties
- CHANGELOG.md file to track project changes

### Changed
- Updated to use AndroidX libraries
- Migrated from android.support libraries to AndroidX
- Optimized build process for better performance and smaller APK size
- Updated README.md with more detailed project information and recent changes
- Increased Gradle daemon JVM memory to 4GB for faster builds
- Updated Kotlin version to 1.8.0
- Updated various AndroidX library versions:
  - core-ktx to 1.12.0
  - appcompat to 1.6.1
  - constraintlayout to 2.1.4
  - recyclerview to 1.3.1
  - activity-ktx to 1.7.2
- Updated Material Design library to 1.9.0
- Changed PDF viewer library to 'com.github.barteksc:android-pdf-viewer:3.2.0-beta.1'

### Fixed
- Resolved conflicts between AndroidX and Support libraries
- Fixed issues with PDF viewer library compatibility
- Addressed manifest merger conflicts by adding tools:replace attribute

### Performance
- Enabled Gradle daemon for faster subsequent builds
- Enabled Gradle parallel execution for faster builds on multi-core systems
- Enabled Gradle build cache to speed up builds by reusing outputs from previous builds
- Enabled R8 full mode for better code optimization
- Enabled resource optimization to remove unused resources
- Disabled BuildConfig generation to reduce APK size
- Enabled AAPT2 for resource processing
- Enabled incremental annotation processing for faster builds
- Enabled Kotlin incremental compilation for faster builds
- Enabled compile avoidance for Kotlin annotation processing

### Gradle Changes
- Updated app/build.gradle:
  - Added resolution strategy for conflicting libraries
  - Enabled minification and resource shrinking for release builds
  - Added multidex support
  - Configured vector drawable support
  - Disabled unused build features
  - Excluded unnecessary files from the APK
- Updated gradle.properties:
  - Added performance optimization flags
  - Increased JVM memory allocation
  - Enabled AndroidX and Jetifier

## [1.0.0] - 2023-09-01

### Added
- Initial release of EasyPDFReader
- Feature to browse PDF files on the device
- PDF viewing functionality with smooth scrolling and zooming
- Support for Android 5.0 (Lollipop) and above
- Adaptive layout for various screen sizes
- RecyclerView for displaying the list of PDF files
- CardView for material design cards in the PDF list
- Basic Gradle configuration for Android project
- Implementation of MVVM architecture
- MainListActivity for displaying PDF list
- PdfListAdapter for handling PDF list in RecyclerView
- PdfViewActivity for viewing individual PDF files

### Changed

### Deprecated

### Removed

### Fixed

### Security

[Unreleased]: https://github.com/yourusername/EasyPDFReader-Android-App-Kotlin/compare/v1.1.0...HEAD
[1.1.0]: https://github.com/yourusername/EasyPDFReader-Android-App-Kotlin/compare/v1.0.0...v1.1.0
[1.0.0]: https://github.com/yourusername/EasyPDFReader-Android-App-Kotlin/releases/tag/v1.0.0
