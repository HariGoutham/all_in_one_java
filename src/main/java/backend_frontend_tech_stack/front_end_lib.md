# Tech Stack and NPM Packages

This document outlines the major libraries and respective NPM packages used in the project.

## 1. **Kubernetes & Helm**
- **Kubernetes**: No specific npm package required for Kubernetes management (typically managed via CLI tools).
- **Helm**: Helm is a CLI tool, no direct npm package required. However, you can interact with it via npm packages like:
    - `helm-connector` (optional)

## 2. **Nginx**
- **Nginx**: Nginx is typically installed as a web server via OS package managers or Docker. No npm package required.

## 3. **CI/CD Tools**
- **GitLab CI/CD**: GitLab CI/CD integration is handled through `.gitlab-ci.yml`, no npm package required.
- **SonarQube**: For integrating with Node.js, use:
    - `sonarqube-scanner`

## 4. **Node.js**
- **Node.js**: No npm package required for Node.js itself, but you use packages for managing Node.js applications.

## 5. **Angular**
- **Angular**:
    - npm package: `@angular/core`
- **ngx-cookie-service**:
    - npm package: `ngx-cookie-service`
- **ngx-translate-multi-http-loader**:
    - npm package: `ngx-translate-multi-http-loader`
- **zone.js**:
    - npm package: `zone.js`

## 6. **Libraries for Excel and PDF**
- **ngx-extended-pdf-viewer**:
    - npm package: `ngx-extended-pdf-viewer`
- **xlsx-js-style**:
    - npm package: `xlsx-js-style`
- **xlsx**:
    - npm package: `xlsx`

## 7. **Testing Libraries**
- **Jest**:
    - npm package: `jest`
- **jest-preset-angular**:
    - npm package: `jest-preset-angular`
- **jest-junit**:
    - npm package: `jest-junit`
- **Jest reporter for SonarQube**:
    - npm package: `jest-sonar-reporter`

## 8. **Linting and Code Formatting**
- **ESLint**:
    - npm package: `eslint`
- **Prettier**:
    - npm package: `prettier`
- **eslint-plugin-prettier**:
    - npm package: `eslint-plugin-prettier`
- **eslint-config-prettier**:
    - npm package: `eslint-config-prettier`

## 9. **Webpack**
- **webpack-bundle-analyzer**:
    - npm package: `webpack-bundle-analyzer`

## 10. **Miscellaneous**
- **numeral**:
    - npm package: `numeral`
- **@babel/runtime**:
    - npm package: `@babel/runtime`
- **@jest/globals**:
    - npm package: `@jest/globals`
- **@types/node**:
    - npm package: `@types/node`
