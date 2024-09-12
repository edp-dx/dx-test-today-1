CREATE TYPE SignalType AS ENUM ('S2', 'S3', 'S4', 'S5', 'S6', 'S7', 'S8');

CREATE TABLE SignalsConfig (
    id UUID PRIMARY KEY,
    signalType SignalType,
    daysPriorToDeadline INTEGER,
    timeOfTheDay TEXT,
    numberOfRetries INTEGER,
    retryInterval INTEGER
);

CREATE TYPE MainTypes AS ENUM ('Briefing', 'DW');

CREATE TABLE SubTypes (
    id UUID PRIMARY KEY,
    name TEXT,
    mainType MainTypes
);

CREATE TABLE SubTypes_SignalsConfig (
    subTypeId UUID REFERENCES SubTypes(id),
    signalsConfigId UUID REFERENCES SignalsConfig(id),
    PRIMARY KEY (subTypeId, signalsConfigId)
);

CREATE TYPE ProjectMainType AS ENUM ('Briefing', 'DW');

CREATE TYPE ProjectSubType AS ENUM ('Worp', 'Mutatie');

CREATE TABLE Projects (
    code UUID PRIMARY KEY,
    fileName TEXT,
    mainType ProjectMainType,
    subType ProjectSubType,
    assortmentCategory TEXT,
    createdOn TIMESTAMP,
    deadline TIMESTAMP,
    inEffectFrom TIMESTAMP
);

CREATE TABLE ValidationsErrors (
    projectCode UUID REFERENCES Projects(code),
    supplierId UUID,
    productId UUID REFERENCES Products(id),
    errorCode UUID REFERENCES Errors(code),
    initialErrorMessage TEXT,
    createdOn TIMESTAMP,
    solvedOn TIMESTAMP,
    PRIMARY KEY (projectCode, supplierId, productId, errorCode)
);

CREATE TYPE ErrorReceiverType AS ENUM ('Supplier', 'CAM');

CREATE TABLE Errors (
    code UUID PRIMARY KEY,
    initialErrorMessage TEXT,
    enrichedErrorMessageEnglish TEXT,
    enrichedErrorMessageDutch TEXT,
    attribute TEXT,
    receiverType ErrorReceiverType
);

CREATE TABLE Products (
    id UUID PRIMARY KEY,
    supplierId UUID,
    assortmentGroup TEXT,
    shortDescription TEXT
);

CREATE TYPE ProductStatus AS ENUM ('Invalid', 'Uploaded');

CREATE TABLE Projects_Products (
    projectId UUID REFERENCES Projects(code),
    productId UUID REFERENCES Products(id),
    status ProductStatus,
    updatedOn TIMESTAMP,
    PRIMARY KEY (projectId, productId)
);

CREATE TABLE CategoryManagers (
    id UUID PRIMARY KEY,
    email TEXT,
    assortmentCategory TEXT
);

CREATE TABLE SupplierUsers (
    id UUID PRIMARY KEY,
    supplierId UUID,
    email TEXT
);

CREATE TABLE Signals (
    id UUID PRIMARY KEY,
    projectCode UUID REFERENCES Projects(code),
    deliveryTime TIMESTAMP,
    delivered BOOLEAN,
    type SignalType,
    invalid BOOLEAN
);

CREATE TABLE ErrorMessages1 (
    errorCode UUID REFERENCES Errors(code),
    english TEXT,
    dutch TEXT,
    PRIMARY KEY (errorCode)
);

CREATE TABLE ErrorMessages2 (
    id UUID PRIMARY KEY,
    errorCode UUID REFERENCES Errors(code),
    languageId UUID REFERENCES ErrorLanguages2(id),
    text TEXT
);

CREATE TABLE ErrorLanguages2 (
    id UUID PRIMARY KEY,
    name TEXT
);

CREATE TYPE ErrorMessages3Language AS ENUM ('English', 'Dutch');

CREATE TABLE ErrorMessages3 (
    errorCode UUID REFERENCES Errors(code),
    language ErrorMessages3Language,
    text TEXT,
    PRIMARY KEY (errorCode)
);