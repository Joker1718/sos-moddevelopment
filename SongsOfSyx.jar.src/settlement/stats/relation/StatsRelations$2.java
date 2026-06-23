/*     */ package settlement.stats.relation;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.IntegerStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   implements SAVABLE
/*     */ {
/*     */   public void save(FilePutter file) {
/*  86 */     file.i(StatsRelations.this.datas.length);
/*  87 */     file.ls(StatsRelations.this.datas);
/*  88 */     file.is(StatsRelations.this.parents);
/*  89 */     file.is(StatsRelations.this.names);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  94 */     int am = file.i();
/*  95 */     StatsRelations.this.datas = new long[am];
/*  96 */     StatsRelations.this.parents = Alloc.ii(am);
/*  97 */     StatsRelations.this.names = Alloc.ii(am);
/*  98 */     file.ls(StatsRelations.this.datas);
/*  99 */     file.is(StatsRelations.this.parents);
/* 100 */     file.is(StatsRelations.this.names);
/* 101 */     StatsRelations.this.free = new IntegerStack(am);
/*     */     
/* 103 */     for (int i = 1; i < am; i++) {
/* 104 */       if (StatsRelations.this.b_idType.get(i) == 0) {
/* 105 */         StatsRelations.this.free.push(i);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 113 */     StatsRelations.this.free = new IntegerStack(40000);
/* 114 */     StatsRelations.this.datas = new long[40000];
/* 115 */     StatsRelations.this.parents = Alloc.ii(40000);
/* 116 */     StatsRelations.this.names = Alloc.ii(40000);
/* 117 */     for (int i = 1; i < StatsRelations.this.datas.length; i++)
/* 118 */       StatsRelations.this.free.push(i); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\relation\StatsRelations$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */