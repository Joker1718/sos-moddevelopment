/*     */ package world.region;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import snake2d.util.sets.LIST;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
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
/*     */ 
/*     */ 
/*     */ class List
/*     */   implements LIST<Region>, Iterator<Region>
/*     */ {
/*     */   private int ii;
/*     */   
/*     */   public Iterator<Region> iterator() {
/*  86 */     this.ii = 0;
/*  87 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Region get(int index) {
/*  92 */     return WORLD.REGIONS().getByIndex(Realm.this.regions.get(index));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(int i) {
/*  97 */     return (i >= 0 && i < Realm.this.regions.size());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Region object) {
/* 102 */     for (int i = 0; i < Realm.this.regions.size(); i++) {
/* 103 */       if (get(i) == object)
/* 104 */         return true; 
/*     */     } 
/* 106 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 111 */     return Realm.this.regions.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 116 */     return Realm.this.regions.isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/* 121 */     return (this.ii < Realm.this.regions.size());
/*     */   }
/*     */ 
/*     */   
/*     */   public Region next() {
/* 126 */     Region r = get(this.ii);
/* 127 */     this.ii++;
/* 128 */     return r;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\Realm$List.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */