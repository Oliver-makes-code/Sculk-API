# Sculk API
An API for interacting with sculk

## Usage

In your repositories block in `build.gradle`:
```groovy
repositories {
    //...
    maven { url "https://maven.proxyfox.dev" }
}
```

In your dependencies block in `build.gradle`:
```groovy
dependencies {
    //...
    modImplementation(include("dev.proxyfox:sculk-api:0.2.0+mc.1.19"))
}
```

To make a block interactable, you need to implement the SculkInteractable interface:
```java
class BlockName extends Block implements SculkInteractable {
    //...

    @Override
    public int onInteract(BlockPos pos, WorldAccess world, int charge) {
        //Return the amount of charge you want to use from the sculk
        return 0;
    }
}
```
