# Project Documentation

## Entities

### SignalType
Enumeration representing various signal types.

### SignalsConfig
Represents configuration for signals.
- `id`: UUID (Primary Key)
- `signalType`: SignalType
- `daysPriorToDeadline`: number
- `timeOfTheDay`: string
- `numberOfRetries`: number
- `retryInterval`: number

### MainTypes
Enumeration representing main types.
- `Briefing`
- `DW`

### SubTypes
Represents sub-types associated with main types.
- `id`: UUID (Primary Key)
- `name`: string
- `mainType`: MainTypes

### SubTypesSignalsConfig
Represents the relationship between sub-types and signal configurations.
- `subTypeId`: UUID (Reference to SubTypes.id)
- `signalsConfigId`: UUID (Reference to SignalsConfig.id)

### ProjectMainType
Enumeration representing project main types.
- `Briefing`
- `DW`

### ProjectSubType
Enumeration representing project sub-types.
- `Worp`
- `Mutatie`

### Projects
Represents project details.
- `code`: UUID (Primary Key)
- `fileName`: text
- `mainType`: ProjectMainType
- `subType`: ProjectSubType
- `assortmentCategory`: text
- `createdOn`: timestamp
- `deadline`: timestamp
- `inEffectFrom`: timestamp

### ValidationsErrors
Represents validation errors for projects.
- `projectCode`: UUID (Reference to Projects.code)
- `supplierId`: UUID
- `productId`: UUID (Reference to Products.id)
- `errorCode`: UUID (Reference to Errors.code)
- `initialErrorMessage`: text
- `createdOn`: timestamp
- `solvedOn`: timestamp

### ErrorReceiverType
Enumeration representing the type of error receiver.
- `Supplier`
- `CAM`

### Errors
Represents error details.
- `code`: UUID (Primary Key)
- `initialErrorMessage`: text
- `enrichedErrorMessageEnglish`: text
- `enrichedErrorMessageDutch`: text
- `attribute`: text
- `receiverType`: ErrorReceiverType

### Products
Represents product details.
- `id`: UUID (Primary Key)
- `supplierId`: UUID
- `assortmentGroup`: text
- `shortDescription`: text

### ProductStatus
Enumeration representing product status.
- `Invalid`
- `Uploaded`

### ProjectsProducts
Represents the relationship between projects and products.
- `projectId`: UUID (Reference to Projects.code)
- `productId`: UUID (Reference to Products.id)
- `status`: ProductStatus
- `updatedOn`: timestamp

### CategoryManagers
Represents category manager details.
- `id`: UUID (Primary Key)
- `email`: text
- `assortmentCategory`: text

### SupplierUsers
Represents supplier user details.
- `id`: UUID (Primary Key)
- `supplierId`: UUID
- `email`: text

### Signals
Represents signal details.
- `id`: UUID (Primary Key)
- `projectCode`: UUID (Reference to Projects.code)
- `deliveryTime`: timestamp
- `delivered`: bool
- `type`: SignalType
- `invalid`: bool

### ErrorMessages1
Represents error messages in different languages.
- `errorCode`: UUID (Reference to Errors.code)
- `english`: text
- `dutch`: text

### ErrorMessages2
Represents error messages with language id.
- `id`: UUID (Primary Key)
- `errorCode`: UUID (Reference to Errors.code)
- `languageId`: UUID (Reference to ErrorLanguages2.id)
- `text`: text

### ErrorLanguages2
Represents error languages.
- `id`: UUID (Primary Key)
- `name`: text

### ErrorMessages3Language
Enumeration representing error message languages.
- `English`
- `Dutch`

### ErrorMessages3
Represents error messages in different languages.
- `errorCode`: UUID (Reference to Errors.code)
- `language`: ErrorMessages3Language
- `text`: text

## Controllers

### SignalsConfigController
Provides CRUD operations for `SignalsConfig`.

### SubTypesController
Provides CRUD operations for `SubTypes`.

### ProjectsController
Provides CRUD operations for `Projects`.

### ValidationsErrorsController
Provides CRUD operations for `ValidationsErrors`.

### ErrorsController
Provides CRUD operations for `Errors`.

### ProductsController
Provides CRUD operations for `Products`.

### ProjectsProductsController
Provides CRUD operations for `ProjectsProducts`.

### CategoryManagersController
Provides CRUD operations for `CategoryManagers`.

### SupplierUsersController
Provides CRUD operations for `SupplierUsers`.

### SignalsController
Provides CRUD operations for `Signals`.

### ErrorMessages1Controller
Provides CRUD operations for `ErrorMessages1`.

### ErrorMessages2Controller
Provides CRUD operations for `ErrorMessages2`.

### ErrorLanguages2Controller
Provides CRUD operations for `ErrorLanguages2`.

### ErrorMessages3Controller
Provides CRUD operations for `ErrorMessages3`.

## Repositories
Repositories for each entity are created to handle database interactions.

---

This documentation provides an overview of the entities and controllers generated for the project. Each controller provides basic CRUD operations for the corresponding entity. Feel free to extend the functionality as needed.

---