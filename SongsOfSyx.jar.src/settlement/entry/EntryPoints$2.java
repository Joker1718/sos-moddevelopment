/*     */ package settlement.entry;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.map.MAP_BOOLEANE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements MAP_BOOLEANE
/*     */ {
/*     */   public boolean is(int tx, int ty) {
/* 205 */     int i = EntryPoints.this.imapi(tx, ty);
/* 206 */     if (i < 0)
/* 207 */       return false; 
/* 208 */     return EntryPoints.this.ismap.get(i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean is(int tile) {
/* 216 */     return is(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */   }
/*     */ 
/*     */   
/*     */   public MAP_BOOLEANE set(int tile, boolean value) {
/* 221 */     return set(tile % SETT.TWIDTH, tile / SETT.TWIDTH, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public MAP_BOOLEANE set(int tx, int ty, boolean value) {
/* 226 */     int i = EntryPoints.this.imapi(tx, ty);
/*     */     
/* 228 */     if (i < 0) {
/* 229 */       return this;
/*     */     }
/* 231 */     EntryPoints.this.dirty = true;
/* 232 */     if (!value) {
/* 233 */       for (EntryPoints.EntryPoint e : EntryPoints.this.all) {
/* 234 */         if (e.coo().isSameAs(tx, ty)) {
/* 235 */           e.active = false;
/* 236 */           EntryPoints.this.ismap.set(EntryPoints.this.imapi(tx, ty), false);
/* 237 */           setActive();
/*     */           break;
/*     */         } 
/*     */       } 
/* 241 */       return this;
/*     */     } 
/*     */     
/* 244 */     EntryPoints.EntryPoint ee = null;
/*     */     
/* 246 */     for (EntryPoints.EntryPoint e : EntryPoints.this.all) {
/* 247 */       if (e.body.holdsPoint(tx, ty)) {
/* 248 */         ee = e;
/*     */ 
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 255 */     EntryPoints.this.ismap.set(EntryPoints.this.imapi(ee.coo().x(), ee.coo().y()), false);
/* 256 */     EntryPoints.this.ismap.set(i, true);
/* 257 */     ee.sCoo.set(tx, ty);
/* 258 */     ee.active = true;
/* 259 */     setActive();
/* 260 */     return this;
/*     */   }
/*     */   
/*     */   private void setActive() {
/* 264 */     EntryPoints.this.active.clearSloppy();
/* 265 */     for (EntryPoints.EntryPoint e : EntryPoints.this.all) {
/* 266 */       if (e.active)
/* 267 */         EntryPoints.this.active.add(e); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entry\EntryPoints$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */