/*    */ package tools.perf;
/*    */ 
/*    */ import snake2d.util.rnd.RND;
/*    */ 
/*    */ class EntityObject
/*    */ {
/*  7 */   private final Physics physics = new Physics();
/*  8 */   private final Mood mood = new Mood();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Physics getPhysics() {
/* 15 */     return this.physics;
/*    */   }
/*    */   
/*    */   public Mood getMood() {
/* 19 */     return this.mood;
/*    */   }
/*    */   
/*    */   static class Physics
/*    */   {
/* 24 */     public int x = RND.rInt();
/* 25 */     public int y = RND.rInt();
/* 26 */     public int z = RND.rInt();
/*    */   }
/*    */ 
/*    */   
/*    */   static class Mood
/*    */   {
/* 32 */     public int a = RND.rInt();
/* 33 */     public int b = RND.rInt();
/* 34 */     public int c = RND.rInt();
/*    */   }
/*    */   
/*    */   static class EntityDataOld
/*    */   {
/*    */     long[] data;
/*    */     
/*    */     EntityDataOld(int size) {
/* 42 */       this.data = new long[size];
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\perf\EntityObject.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */