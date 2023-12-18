package items;

import enums.State;

public abstract class Seeds {
        private float size;
        private State state;
        private String type;
        {
            state = State.NOT_SPROUTED;
        }
        public Seeds(float size, String type){
            this.size = size;
            this.type = type;
        }


    public void setState(State state){
        this.state = state;
    }

    public abstract void growUp();

    public String getType(){
        return this.type;
    }

    public void setSize(float size){
        this.size = size;
    }

    public float getSize(){
        return this.size;
    }
}

