
### Basic CRUD operations:

C — create 

```
entityManager.persist(EntityType)
```

R - Read / find

```
TypedQuery<EntityType> q = entityManager.CreateQuery("SQL Query”, EntityType)
q.getResultList()
```

// find by id
```
entityManger.find(by UniqueID)
```

U — Update

```
enittyManager.merge(entityType)
If entityType has 0 in its primary key, then it will insert a new record. Otherwise it will update the existing record.
```

D - Delete:

```
EntityType entity = entityManger.find(by id);
entityManger.remove(entity)
```

### Basic architecture:

Service layer: Annotated with @Service

DOA(Data Object Access) layer: Annotated with @Repository

```
Rest Controller <——> Service <——> DAO layer <—> DB
Transaction should be applied to Service layer, not DAO layer.
```

