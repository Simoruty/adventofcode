package com.simoruty;

public class Sue {
    private int id;
    private int children;
    private int cats;
    private int samoyeds;
    private int pomeranians;
    private int akitas;
    private int vizslas;
    private int goldfish;
    private int trees;
    private int cars;
    private int perfumes;

    public Sue() {
        id = -1;
        children = -1;
        cats = -1;
        samoyeds = -1;
        pomeranians = -1;
        akitas = -1;
        vizslas = -1;
        goldfish = -1;
        trees = -1;
        cars = -1;
        perfumes = -1;
    }

    public Sue(int children, int cats, int samoyeds, int pomeranians, int akitas, int vizslas, int goldfish, int trees, int cars, int perfumes) {
        this.children = children;
        this.cats = cats;
        this.samoyeds = samoyeds;
        this.pomeranians = pomeranians;
        this.akitas = akitas;
        this.vizslas = vizslas;
        this.goldfish = goldfish;
        this.trees = trees;
        this.cars = cars;
        this.perfumes = perfumes;
    }

    public Sue(int id, int children, int cats, int samoyeds, int pomeranians, int akitas, int vizslas, int goldfish, int trees, int cars, int perfumes) {
        this.id = id;
        this.children = children;
        this.cats = cats;
        this.samoyeds = samoyeds;
        this.pomeranians = pomeranians;
        this.akitas = akitas;
        this.vizslas = vizslas;
        this.goldfish = goldfish;
        this.trees = trees;
        this.cars = cars;
        this.perfumes = perfumes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getCats() {
        return cats;
    }

    public void setCats(int cats) {
        this.cats = cats;
    }

    public int getSamoyeds() {
        return samoyeds;
    }

    public void setSamoyeds(int samoyeds) {
        this.samoyeds = samoyeds;
    }

    public int getPomeranians() {
        return pomeranians;
    }

    public void setPomeranians(int pomeranians) {
        this.pomeranians = pomeranians;
    }

    public int getAkitas() {
        return akitas;
    }

    public void setAkitas(int akitas) {
        this.akitas = akitas;
    }

    public int getVizslas() {
        return vizslas;
    }

    public void setVizslas(int vizslas) {
        this.vizslas = vizslas;
    }

    public int getGoldfish() {
        return goldfish;
    }

    public void setGoldfish(int goldfish) {
        this.goldfish = goldfish;
    }

    public int getTrees() {
        return trees;
    }

    public void setTrees(int trees) {
        this.trees = trees;
    }

    public int getCars() {
        return cars;
    }

    public void setCars(int cars) {
        this.cars = cars;
    }

    public int getPerfumes() {
        return perfumes;
    }

    public void setPerfumes(int perfumes) {
        this.perfumes = perfumes;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder().append("Sue{")
                .append("id=").append(id);
        if (children != -1)
            s.append(", children=").append(children);
        if (cats != -1)
            s.append(", cats=").append(cats);
        if (samoyeds != -1)
            s.append(", samoyeds=").append(samoyeds);
        if (pomeranians != -1)
            s.append(", pomeranians=").append(pomeranians);
        if (akitas != -1)
            s.append(", akitas=").append(akitas);
        if (vizslas != -1)
            s.append(", vizslas=").append(vizslas);
        if (goldfish != -1)
            s.append(", goldfish=").append(goldfish);
        if (trees != -1)
            s.append(", trees=").append(trees);
        if (cars != -1)
            s.append(", cars=").append(cars);
        if (perfumes != -1)
            s.append(", perfumes=").append(perfumes);
        s.append('}');
        return s.toString();
    }

    public boolean contains(Sue aunt) {
        int tot = 0;
        if (akitas == aunt.getAkitas() && akitas != -1)
            tot++;
        if (cars == aunt.getCars() && cars != -1)
            tot++;
        if (cats == aunt.getCats() && cats != -1)
            tot++;
        if (children == aunt.getChildren() && children != -1)
            tot++;
        if (goldfish == aunt.getGoldfish() && goldfish != -1)
            tot++;
        if (perfumes == aunt.getPerfumes() && perfumes != -1)
            tot++;
        if (pomeranians == aunt.getPomeranians() && pomeranians != -1)
            tot++;
        if (samoyeds == aunt.getSamoyeds() && samoyeds != -1)
            tot++;
        if (trees == aunt.getTrees() && trees != -1)
            tot++;
        if (vizslas == aunt.getVizslas() && vizslas != -1)
            tot++;

        return tot == size();
    }

    private int size() {
        int size = 0;
        if (akitas != -1)
            size++;
        if (cars != -1)
            size++;
        if (cats != -1)
            size++;
        if (children != -1)
            size++;
        if (goldfish != -1)
            size++;
        if (perfumes != -1)
            size++;
        if (pomeranians != -1)
            size++;
        if (samoyeds != -1)
            size++;
        if (trees != -1)
            size++;
        if (vizslas != -1)
            size++;
        return size;
    }

}
