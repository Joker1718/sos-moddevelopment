/*     */ package world.army;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import snake2d.util.sets.LIST;
/*     */ import world.WORLD;
/*     */ import world.entity.army.WArmy;
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
/*     */ final class List
/*     */   implements LIST<WArmy>, Iterator<WArmy>
/*     */ {
/*     */   private int ii;
/*     */   
/*     */   public Iterator<WArmy> iterator() {
/*  81 */     this.ii = 0;
/*  82 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public WArmy get(int index) {
/*  87 */     WArmy a = (WORLD.ENTITIES()).armies.get(ADArmies.this.armies.get(index));
/*  88 */     if (a == null)
/*  89 */       throw new RuntimeException("" + index + " " + index + " " + ADArmies.this.armies.get(index)); 
/*  90 */     return a;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(int i) {
/*  95 */     return (i >= 0 && i < ADArmies.this.armies.size());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(WArmy object) {
/* 100 */     for (int i = 0; i < ADArmies.this.armies.size(); i++) {
/* 101 */       if (get(i) == object)
/* 102 */         return true; 
/*     */     } 
/* 104 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 109 */     return ADArmies.this.armies.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 114 */     return ADArmies.this.armies.isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/* 119 */     return (this.ii < ADArmies.this.armies.size());
/*     */   }
/*     */ 
/*     */   
/*     */   public WArmy next() {
/* 124 */     WArmy r = get(this.ii);
/* 125 */     this.ii++;
/* 126 */     return r;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADArmies$List.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */