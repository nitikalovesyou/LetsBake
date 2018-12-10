package com.kamalmrock.example.bakingapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Recipe implements Parcelable {
    private int id;
    private String name;
    private List<com.kamalmrock.example.bakingapp.models.RecipeIngredient> ingredients;
    private List<com.kamalmrock.example.bakingapp.models.RecipeStep> steps;
    private int servings;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<com.kamalmrock.example.bakingapp.models.RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<com.kamalmrock.example.bakingapp.models.RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<com.kamalmrock.example.bakingapp.models.RecipeStep> getSteps() {
        return steps;
    }

    public void setSteps(List<com.kamalmrock.example.bakingapp.models.RecipeStep> steps) {
        this.steps = steps;
    }
    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeList(ingredients);
        dest.writeList(steps);
        dest.writeInt(servings);
        dest.writeString(image);
    }

    //CREATOR
    public static final Parcelable.Creator<Recipe> CREATOR = new Parcelable.Creator<Recipe>(){

        @Override
        public Recipe createFromParcel(Parcel source) {
            return new Recipe(source);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    public Recipe(Parcel in){
        id = in.readInt();
        name = in.readString();
        ingredients = in.readArrayList(com.kamalmrock.example.bakingapp.models.RecipeIngredient.class.getClassLoader());
        steps = in.readArrayList(com.kamalmrock.example.bakingapp.models.RecipeStep.class.getClassLoader());
        servings = in.readInt();
        image = in.readString();
    }
}
