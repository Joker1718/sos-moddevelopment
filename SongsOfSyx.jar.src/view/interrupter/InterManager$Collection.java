/*     */ package view.interrupter;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import snake2d.util.sets.ArrayList;
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
/*     */ class Collection
/*     */   implements Iterable<Interrupter>, Iterator<Interrupter>
/*     */ {
/*     */   private int i;
/* 180 */   private final ArrayList<Interrupter> all = new ArrayList(64);
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/* 184 */     if (this.i < 0)
/* 185 */       this.i = 0; 
/* 186 */     return (this.i < this.all.size());
/*     */   }
/*     */ 
/*     */   
/*     */   public Interrupter next() {
/* 191 */     if (this.i < 0)
/* 192 */       this.i = 0; 
/* 193 */     return (Interrupter)this.all.get(this.i++);
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<Interrupter> iterator() {
/* 198 */     this.i = 0;
/* 199 */     return this;
/*     */   }
/*     */   
/*     */   void add(Interrupter i) {
/* 203 */     this.all.add(i);
/*     */   }
/*     */ 
/*     */   
/*     */   void addFirst(Interrupter i) {
/* 208 */     this.all.insert(0, i);
/* 209 */     if (this.i > 0) {
/* 210 */       this.i--;
/*     */     }
/*     */   }
/*     */   
/*     */   void remove(Interrupter i) {
/* 215 */     int index = this.all.removeOrdered(i);
/* 216 */     if (index < 0)
/* 217 */       throw new RuntimeException(); 
/* 218 */     if (index <= this.i)
/* 219 */       this.i--; 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\interrupter\InterManager$Collection.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */