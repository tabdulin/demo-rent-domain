create table individual (
  id uuid primary key,
  deleted boolean not null default false,

  name text not null
);

create table company (
  id uuid primary key,
  deleted boolean default false,

  name text not null,
  representative_id uuid not null references individual
);

create table landlord (
  id uuid primary key,
  deleted boolean default false,

  type text not null,
  individual_id uuid references individual,
  company_id uuid references company

  constraint landlord_type_check check (
    (type = 'INDIVIDUAL' or type = 'COMPANY')
    and
    case
      when type = 'INDIVIDUAL' then individual_id is not null and company_id is null
      when type = 'COMPANY' then company_id is not null and individual_id is null
    end
  )
);

create table tenant (
  id uuid primary key,
  deleted boolean default false,

  type text not null,
  individual_id uuid references individual,
  company_id uuid references company,

  constraint tenant_type_check check (
    (type = 'INDIVIDUAL' or type = 'COMPANY')
    and
    case
      when type = 'INDIVIDUAL' then individual_id is not null and company_id is null
      when type = 'COMPANY' then company_id is not null and individual_id is null
    end
  )
);

create table building (
  id uuid primary key,
  deleted boolean default false,

  address text not null
);

create table apartment (
  id uuid primary key,
  deleted boolean default false,

  address text not null,
  building_id uuid references building
);


create table property (
  id uuid primary key,
  deleted boolean,

  type text not null,
  building_id uuid references building,
  apartment_id uuid references apartment,
  landlord_id uuid not null references landlord,

  constraint property_type_check check (
    (type = 'BUILDING' or type = 'APARTMENT')
    and
    case
      when type = 'BUILDING' then building_id is not null and apartment_id is null
      when type = 'APARTMENT' then apartment_id is not null and building_id is null
    end
  ),

  constraint property_unique unique (id, landlord_id)
);

create table contract (
  id uuid primary key,
  deleted boolean,

  landlord_id uuid references landlord,
  start_date date not null,
  end_date date not null,
  price numeric(12,2) not null,

  constraint contract_unique unique (id, landlord_id)
);

create table contract_property (
  contract_id uuid not null references contract,
  property_id uuid not null references property
);

create table contract_tenant (
  contract_id uuid not null references contract,
  tenant_id uuid not null references tenant
)


