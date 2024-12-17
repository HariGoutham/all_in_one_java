# Project Tech Stack

## Frontend

### **Angular**
- **Angular CLI**: For managing Angular projects.
- **Core Concepts**: Angular components, services, and modules.
- **Version**: Angular 15.3.3.

### **TypeScript**
- **Usage**: Used for development (`.ts` files, `tsconfig.json`).

### **GraphQL**
- **Code Generation**: Utilized with `@graphql-codegen` packages in `package.json`.

### **RxJS**
- **Reactive Programming**: Implemented with `rxjs` package.

### **NgRx**
- **State Management**: Handled using `@ngrx/store-devtools` package.

### **Jest**
- **Testing Framework**: Includes `jest`, `jest-environment-jsdom`, `jest-junit`, and `jest-preset-angular` packages.

### **Karma**
- **Test Runner**: Configured with the following packages:
    - `karma`
    - `karma-jasmine`
    - `karma-chrome-launcher`
    - `karma-jasmine-html-reporter`
    - `karma-coverage` (defined in `karma.conf.js`).

### **ESLint**
- **Linting**: Configured with these packages:
    - `eslint`
    - `@typescript-eslint/eslint-plugin`
    - `@typescript-eslint/parser`
    - `eslint-config-prettier`
    - `eslint-plugin-prettier`
    - `eslint-plugin-unused-imports`.

### **Prettier**
- **Code Formatting**: Configured in `.prettierrc.json`.

---

## Backend and Infrastructure

### **Docker**
- **Containerization**: Managed using `Dockerfile`.

### **Kubernetes**
- **Orchestration**: Resources managed in the `kube` directory.
- **Ingress**: Defined in `ingress-mitigant-ui.yaml` and `values.yaml`.

### **Helm**
- **Kubernetes Package Management**: Configuration present in `helm` tags in `.gitlab-ci.yml`.

### **Nginx**
- **Web Server and Reverse Proxy**:
    - Configuration: `nginx.conf`.
    - Integration: Defined in `Dockerfile`.

---

## CI/CD

### **GitLab CI/CD**
- **Continuous Integration and Deployment**:
    - Configuration files: `.gitlab-ci.yml`.
    - Directory: `build/ci`.

### **SonarQube**
- **Code Quality Analysis**:
    - Integrated via `sonar-scanner` commands in `.gitlab-ci.yml`.

---

## Configuration and Scripting

### **YAML**
- **Configuration Files**:
    - `.gitlab-ci.yml`.
    - `values.yaml`.
    - `build/ci-templates/*.yaml`.

### **Shell Scripting**
- **Scripts**: Various shell commands for CI/CD pipelines.

---

## Miscellaneous

### **Node.js**
- **Node.js Packages and Scripts**:
    - Managed in `package.json`.
    - Used for features like a feedback widget (`src/app/app.component.ts`).

### **PDF Viewer**
- **PDF Viewing**: Integrated with the `ngx-extended-pdf-viewer` package.

### **Excel Handling**
- **Excel File Management**:
    - Implemented with `xlsx` and `xlsx-js-style` packages.
