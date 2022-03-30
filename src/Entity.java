package src;

public class Entity
{
    private Mesh mesh;

    private double translationX;
    private double translationY;
    private double translationZ;

    private double scaleX = 1.0;
    private double scaleY = 1.0;
    private double scaleZ = 1.0;

    private double rotationX;
    private double rotationY;
    private double rotationZ;

    public Entity()
    {

    }

    /**
    * Creates a new entity with default translation and scale
    * @param mesh Mesh of entity
    */
    public Entity(Mesh mesh)
    {
        this.mesh = mesh;
    }

    /**
    * Creates a new entity with translations 
    * @param mesh Mesh of entity
    * @param translationX translation of entity on X axis
    * @param translationY translation of entity on Y axis
    * @param translationZ translation of entity on Z axis
    */
    public Entity(Mesh mesh, double translationX, double translationY, double translationZ)
    {
        this.mesh = mesh;

        this.translationX = translationX;
        this.translationY = translationY;
        this.translationZ = translationZ;
    }

    /**
    * Creates a new entity with translations and scale
    * @param mesh Mesh of entity
    * @param translationX translation of entity on X axis
    * @param translationY translation of entity on Y axis
    * @param translationZ translation of entity on Z axis
    * @param scaleX scale of entity on X axis
    * @param scaleY scale of entity on Y axis
    * @param scaleZ scale of entity on Z axis
    */
    public Entity(Mesh mesh, double translationX, double translationY, double translationZ, double scaleX, double scaleY, double scaleZ)
    {
        this.mesh = mesh;

        this.translationX = translationX;
        this.translationY = translationY;
        this.translationZ = translationZ;

        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.scaleZ = scaleZ;
    }

    /**
    * Creates a new entity with translations and scale
    * @param mesh Mesh of entity
    * @param translationX translation of entity on X axis
    * @param translationY translation of entity on Y axis
    * @param translationZ translation of entity on Z axis
    * @param scaleX scale of entity on X axis
    * @param scaleY scale of entity on Y axis
    * @param scaleZ scale of entity on Z axis
    * @param rotationX rotation of entity on X axis
    * @param rotationY rotation of entity on Y axis
    * @param rotationZ rotation of entity on Z axis
    */
    public Entity(Mesh mesh, double translationX, double translationY, double translationZ, double scaleX, double scaleY, double scaleZ, double rotationX, double rotationY, double rotationZ)
    {
        this.mesh = mesh;

        this.translationX = translationX;
        this.translationY = translationY;
        this.translationZ = translationZ;

        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.scaleZ = scaleZ;

        this.rotationX = rotationX;
        this.rotationY = rotationY;
        this.rotationZ = rotationZ;
    }

    //Getters

    public Mesh getMesh()
    {
        return this.mesh;
    }

    //Scale getters

    /**
    * Returns entity scale on the X axis
    */
    public double getScaleX()
    {
        return this.scaleX;
    }

    /**
    * Returns entity scale on the Y axis
    */
    public double getScaleY()
    {
        return this.scaleY;
    }

    /**
    * Returns entity scale on the Z axis
    */
    public double getScaleZ()
    {
        return this.scaleZ;
    }



    //Translation getters

    /**
    * Returns entity translation on the X axis
    */
    public double getTranslationX()
    {
        return this.translationX;
    }

    /**
    * Returns entity translation on the Y axis
    */
    public double getTranslationY()
    {
        return this.translationY;
    }

    /**
    * Returns entity translation on the Z axis
    */
    public double getTranslationZ()
    {
        return this.translationZ;
    }



    //Rotation getters

    /**
    * Returns entity rotation on the X axis
    */
    public double getRotationX()
    {
        return this.rotationX;
    }

    /**
    * Returns entity rotation on the Y axis
    */
    public double getRotationY()
    {
        return this.rotationY;
    }

    /**
    * Returns entity rotation on the Z axis
    */
    public double getRotationZ()
    {
        return this.rotationZ;
    }






    //Setters

    //Scale setters

    /**
    * Sets the exact scale of entity on the X axis
    * @param scaleX scale on the X axis
    */
    public void setScaleX(double scaleX)
    {
        this.scaleX = scaleX;
    }

    /**
    * Sets the exact scale of entity on the Y axis
    * @param scaleY scale on the Y axis
    */
    public void setScaleY(double scaleY)
    {
        this.scaleY = scaleY;
    }

    /**
    * Sets the exact scale of entity on the Z axis
    * @param scaleZ scale on the Z axis
    */
    public void setScaleZ(double scaleZ)
    {
        this.scaleZ = scaleZ;
    }

    /**
    * Sets the exact scale of entity on the X, Y and Z axes
    * @param scaleX scale on the X axis
    * @param scaleY scale on the Y axis
    * @param scaleZ scale on the Z axis
    */
    public void setScale(double scaleX, double scaleY, double scaleZ)
    {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.scaleZ = scaleZ;
    }


    //Scale incrementors

    /**
    * Changes the scale of the entity on the X axis
    * @param scaleX scale change
    */
    public void scaleX(double scaleX)
    {
        this.scaleX += scaleX;
    }

    /**
    * Changes the scale of the entity on the Y axis
    * @param scaleY scale change on the Y axis
    */
    public void scaleY(double scaleY)
    {
        this.scaleY += scaleY;
    }

    /**
    * Changes the scale of the entity on the Z axis
    * @param scaleZ scale change on the Z axis
    */
    public void scaleZ(double scaleZ)
    {
        this.scaleZ += scaleZ;
    }

    /**
    * Changes the scale of the entity on the X, Y and Z axes
    * @param scaleX scale change on the X axis
    * @param scaleY scale change on the Y axis
    * @param scaleZ scale change on the Z axis
    */
    public void scale(double scaleX, double scaleY, double scaleZ)
    {
        this.scaleX += scaleX;
        this.scaleY += scaleY;
        this.scaleZ += scaleZ;
    }



    //Translation setters

    /**
    * Sets the exact translation of entity on the X axis
    * @param translationX sets translation on the X axis
    */
    public void setTranslationX(double translationX)
    {
        this.translationX = translationX;
    }

    /**
    * Sets the exact translation of entity on the Y axis
    * @param translationY sets translation on the Y axis
    */
    public void setTranslationY(double translationY)
    {
        this.translationY = translationY;
    }

    /**
    * Sets the exact translation of entity on the Z axis
    * @param translationZ sets translation on the Z axis
    */
    public void setTranslationZ(double translationZ)
    {
        this.translationZ = translationZ;
    }

    /**
    * Sets the exact translation of entity on the X, Y and Z axes
    * @param translationX sets translation on the X axis
    * @param translationY sets translation on the Y axis
    * @param translationZ sets translation on the Z axis
    */
    public void setTranslation(double translationX, double translationY, double translationZ)
    {
        this.translationX = translationX;
        this.translationY = translationY;
        this.translationZ = translationZ;
    }


    //Translation incrementors

    /**
    * Translates the entity on the X axis
    * @param translateX translation on the X axis
    */
    public void translateX(double translateX)
    {
        this.translationX += translateX;
    }

    /**
    * Translates the entity on the Y axis
    * @param translateY translation on the Y axis
    */
    public void translateY(double translateY)
    {
        this.translationY += translateY;
    }

    /**
    * Translates the entity on the Z axis
    * @param translateZ translation on the Z axis
    */
    public void translateZ(double translateZ)
    {
        this.translationZ += translateZ;
    }

    /**
    * Translates the entity on the X, Y and Z axes
    * @param translateX translation on the X axis
    * @param translateY translation on the Y axis
    * @param translateZ translation on the Z axis
    */
    public void translate(double translateX, double translateY, double translateZ)
    {
        this.translationX += translateX;
        this.translationY += translateY;
        this.translationZ += translateZ;
    }





    //Rotation setters

    /**
    * Sets the exact rotation of entity on the X axis
    * @param rotationX sets rotation on the X axis
    */
    public void setRotationX(double rotationX)
    {
        this.rotationX = rotationX;
    }

    /**
    * Sets the exact rotation of entity on the Y axis
    * @param rotationY sets rotation on the Y axis
    */
    public void setRotationY(double rotationY)
    {
        this.rotationY = rotationY;
    }

    /**
    * Sets the exact rotation of entity on the Z axis
    * @param rotationZ sets rotation on the Z axis
    */
    public void setRotationZ(double rotationZ)
    {
        this.rotationZ = rotationZ;
    }

    /**
    * Sets the exact rotation of entity on the X, Y and Z axes
    * @param rotationX sets rotation on the X axis
    * @param rotationY sets rotation on the Y axis
    * @param rotationZ sets rotation on the Z axis
    */
    public void setRotation(double rotationX, double rotationY, double rotationZ)
    {
        this.rotationX = rotationX;
        this.rotationY = rotationY;
        this.rotationZ = rotationZ;
    }


    //Rotation incrementors

    /**
    * Rotates the entity on the X axis
    * @param rotateX rotation on the X axis
    */
    public void rotateX(double rotateX)
    {
        this.rotationX += rotateX;
    }

    /**
    * Rotates the entity on the Y axis
    * @param rotateY rotation on the Y axis
    */
    public void rotateY(double rotateY)
    {
        this.rotationY += rotateY;
    }

    /**
    * Rotates the entity on the Z axis
    * @param rotateZ rotation on the Z axis
    */
    public void rotateZ(double rotateZ)
    {
        this.rotationZ += rotateZ;
    }

    /**
    * Rotates the entity on the X, Y and Z axes
    * @param rotateX rotation on the X axis
    * @param rotateY rotation on the Y axis
    * @param rotateZ rotation on the Z axis
    */
    public void rotate(double rotateX, double rotateY, double rotateZ)
    {
        this.rotationX += rotateX;
        this.rotationY += rotateY;
        this.rotationZ += rotateZ;
    }
}
