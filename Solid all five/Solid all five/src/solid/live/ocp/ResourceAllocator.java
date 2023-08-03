package solid.live.ocp;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 11, 2011
 * Time: 1:14:09 PM
 * To change this template use File | Settings | File Templates.
 */


public interface Resource {
    int findFreeResource();
    void markResourceBusy(int resourceId);
    void markResourceFree(int resourceId);
}

public class ResourceAllocator {
    private final Resource resource;

    public ResourceAllocator(Resource resource) {
        this.resource = resource;
    }

    public int allocate() {
        int resourceId = resource.findFreeResource();
        if (resourceId != -1) {
            resource.markResourceBusy(resourceId);
        } else {
            System.out.println("ERROR: Unable to allocate resource");
        }
        return resourceId;
    }

    public void free(int resourceId) {
        resource.markResourceFree(resourceId);
    }
}

public class TimeSlotResource implements Resource {
    @Override
    public int findFreeResource() {
        return 0;
    }

    @Override
    public void markResourceBusy(int resourceId) {
    }

    @Override
    public void markResourceFree(int resourceId) {
    }
}

public class SpaceSlotResource implements Resource {
    @Override
    public int findFreeResource() {
        return 0;
    }

    @Override
    public void markResourceBusy(int resourceId) {
    }

    @Override
    public void markResourceFree(int resourceId) {
    }
}
