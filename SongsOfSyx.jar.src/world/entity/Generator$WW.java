/*     */ package world.entity;
/*     */ 
/*     */ import init.type.CLIMATE;
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.Tree;
/*     */ import world.entity.haven.WHavenType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class WW
/*     */ {
/*  82 */   double am = 0.0D;
/*  83 */   private final Tree<Generator.Coovalue> spots = new Tree<Generator.Coovalue>(1024)
/*     */     {
/*     */       protected boolean isGreaterThan(Generator.Coovalue current, Generator.Coovalue cmp)
/*     */       {
/*  87 */         return (current.value > cmp.value);
/*     */       }
/*     */     };
/*     */   
/*     */   WW(WHavenType w) {
/*  92 */     this.w = w;
/*     */   }
/*     */   public final WHavenType w;
/*     */   void add(int tx, int ty, CLIMATE cl) {
/*  96 */     double res = 0.0D;
/*  97 */     for (TERRAIN t : TERRAINS.ALL()) {
/*  98 */       res += this.w.climates[cl.index()] * this.w.terrains[t.index()] * t.value(tx, ty);
/*     */     }
/* 100 */     this.am += res;
/*     */     
/* 102 */     if (!this.spots.hasRoom()) {
/* 103 */       if (((Generator.Coovalue)this.spots.smallest()).value < res) {
/* 104 */         this.spots.pollSmallest();
/*     */       } else {
/*     */         return;
/*     */       } 
/*     */     }
/*     */     
/* 110 */     Generator.Coovalue v = new Generator.Coovalue();
/* 111 */     v.value = res * RND.rFloat();
/* 112 */     v.tx = (short)tx;
/* 113 */     v.ty = (short)ty;
/* 114 */     this.spots.add(v);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\Generator$WW.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */