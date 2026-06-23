/*     */ package settlement.entry;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 154 */     for (EntryPoints.EntryPoint p : EntryPoints.this.all) {
/* 155 */       p.save(file);
/*     */     }
/*     */   }
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 160 */     clear();
/*     */     
/* 162 */     for (EntryPoints.EntryPoint p : EntryPoints.this.all)
/* 163 */       p.load(file); 
/* 164 */     for (EntryPoints.EntryPoint p : EntryPoints.this.all) {
/* 165 */       if (p.reachable)
/* 166 */         EntryPoints.this.reachable.add(p); 
/* 167 */       if (p.active) {
/* 168 */         EntryPoints.this.active.add(p);
/* 169 */         EntryPoints.this.ismap.set(EntryPoints.this.imapi(p.coo().x(), p.coo().y()), true);
/*     */       } 
/*     */     } 
/*     */     
/* 173 */     EntryPoints.this.dirty = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 178 */     EntryPoints.this.dirty = true;
/* 179 */     EntryPoints.this.ismap.clear();
/* 180 */     for (EntryPoints.EntryPoint p : EntryPoints.this.all)
/* 181 */       p.clear(); 
/* 182 */     EntryPoints.this.active.clearSloppy();
/* 183 */     EntryPoints.this.reachable.clearSloppy();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entry\EntryPoints$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */