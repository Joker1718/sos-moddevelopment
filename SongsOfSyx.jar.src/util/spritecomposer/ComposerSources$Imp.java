/*     */ package util.spritecomposer;
/*     */ 
/*     */ import snake2d.LOG;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Imp
/*     */   extends ComposerSources.Source
/*     */ {
/*     */   protected int size;
/*     */   private ComposerDests.Dest dest;
/*     */   
/*     */   public abstract boolean next();
/*     */   
/*     */   public abstract ComposerSources.Source setVar(int paramInt);
/*     */   
/*     */   public abstract ComposerSources.Source setSkip(int paramInt1, int paramInt2);
/*     */   
/*     */   public void paste(int dupRot, boolean setNext) {
/* 204 */     int i = 0;
/*     */     
/* 206 */     paste(setNext);
/*     */     
/* 208 */     for (int rot = 1; rot <= dupRot; ) {
/* 209 */       setRot(rot);
/*     */       while (true) {
/* 211 */         Resources.c.copy(this);
/* 212 */         Resources.c.pasteRotated(this.dest, rot);
/* 213 */         this.dest.jump(1);
/* 214 */         i++;
/* 215 */         if (next())
/*     */           rot++; 
/*     */       } 
/* 218 */     }  if (!setNext) {
/* 219 */       this.dest.jump(-i);
/*     */     }
/*     */   }
/*     */   
/*     */   public void paste(boolean setNext) {
/* 224 */     int i = 0;
/*     */     
/* 226 */     setRot(0);
/*     */     do {
/* 228 */       Resources.c.copy(this);
/* 229 */       Resources.c.paste(this.dest);
/* 230 */       this.dest.jump(1);
/* 231 */       i++;
/* 232 */     } while (!next());
/*     */     
/* 234 */     if (!setNext) {
/* 235 */       this.dest.jump(-i);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void pasteOverBackground(boolean setNext, double blend) {
/* 241 */     int i = 0;
/*     */     
/* 243 */     setRot(0);
/*     */     do {
/* 245 */       Resources.c.copy(this);
/* 246 */       Resources.c.paste(this.dest, blend);
/* 247 */       this.dest.jump(1);
/* 248 */       i++;
/* 249 */     } while (!next());
/*     */     
/* 251 */     if (!setNext) {
/* 252 */       this.dest.jump(-i);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void pasteRotated(int rotation, boolean setNext) {
/* 259 */     if (rotation == 0) {
/* 260 */       paste(setNext);
/*     */       
/*     */       return;
/*     */     } 
/* 264 */     int i = 0;
/*     */     
/* 266 */     setRot(rotation);
/*     */     do {
/* 268 */       Resources.c.copy(this);
/* 269 */       Resources.c.pasteRotated(this.dest, rotation);
/* 270 */       this.dest.jump(1);
/* 271 */       i++;
/* 272 */     } while (!next());
/*     */     
/* 274 */     if (!setNext) {
/* 275 */       this.dest.jump(-i);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void pasteStenciled(Imp stencil, int dupRot) {
/* 281 */     stencil.setRot(0);
/*     */     do {
/* 283 */       Resources.c.blendWithBackground(this.dest, stencil, this);
/* 284 */       Resources.c.paste(this.dest);
/* 285 */       this.dest.jump(1);
/* 286 */       next();
/* 287 */     } while (!stencil.next());
/*     */     
/* 289 */     for (int rot = 1; rot <= dupRot; ) {
/* 290 */       stencil.setRot(rot);
/*     */       while (true) {
/* 292 */         Resources.c.blendWithBackground(this.dest, stencil, this);
/* 293 */         Resources.c.pasteRotated(this.dest, rot);
/* 294 */         this.dest.jump(1);
/* 295 */         next();
/* 296 */         if (stencil.next())
/*     */           rot++; 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void pasteNormal(int dupRot, boolean setNext) {
/* 303 */     int i = 0;
/*     */     
/* 305 */     setRot(0);
/*     */     do {
/* 307 */       Resources.c.copy(this);
/* 308 */       Resources.c.pasteNormalOnly(this.dest, 0);
/* 309 */       this.dest.jump(1);
/* 310 */       i++;
/* 311 */     } while (!next());
/*     */     
/* 313 */     for (int rot = 1; rot <= dupRot; ) {
/* 314 */       setRot(rot);
/*     */       while (true) {
/* 316 */         Resources.c.copy(this);
/* 317 */         Resources.c.pasteNormalOnly(this.dest, rot);
/* 318 */         this.dest.jump(1);
/* 319 */         i++;
/* 320 */         if (next())
/*     */           rot++; 
/*     */       } 
/* 323 */     }  if (!setNext) {
/* 324 */       this.dest.jump(-i);
/*     */     }
/*     */   }
/*     */   
/*     */   public void pasteEdges(boolean setNext) {
/* 329 */     this.dest.jump(1);
/* 330 */     Resources.c.copy(this);
/*     */     
/* 332 */     for (int i = 1; i < 16; i++) {
/*     */       
/* 334 */       if ((i & 0x1) > 0)
/* 335 */         Resources.c.paste(this.dest); 
/* 336 */       if ((i & 0x2) > 0)
/* 337 */         Resources.c.pasteRotated(this.dest, 1); 
/* 338 */       if ((i & 0x4) > 0)
/* 339 */         Resources.c.pasteRotated(this.dest, 2); 
/* 340 */       if ((i & 0x8) > 0)
/* 341 */         Resources.c.pasteRotated(this.dest, 3); 
/* 342 */       this.dest.jump(1);
/*     */     } 
/* 344 */     if (!setNext) {
/* 345 */       this.dest.jump(-16);
/*     */     }
/*     */   }
/*     */   
/*     */   void setDest(ComposerDests.Dest dest) {
/* 350 */     this.dest = dest;
/* 351 */     this.size = dest.size();
/*     */   }
/*     */ 
/*     */   
/*     */   abstract void setRot(int paramInt);
/*     */ 
/*     */   
/*     */   abstract int height();
/*     */ 
/*     */   
/*     */   abstract int width();
/*     */ 
/*     */   
/*     */   abstract int x1();
/*     */   
/*     */   abstract int y1();
/*     */   
/*     */   public final void debug() {
/* 369 */     LOG.ln("" + x1() + " " + x1());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\ComposerSources$Imp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */