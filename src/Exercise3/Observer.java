package Exercise3;

interface Observer<T, U> {
    void update(Package self, PackageState newState);
}