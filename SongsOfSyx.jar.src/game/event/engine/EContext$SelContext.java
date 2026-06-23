/*     */ package game.event.engine;
/*     */ 
/*     */ import init.value.Lockable;
/*     */ import java.io.Serializable;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class SelContext<T>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/* 255 */   public int am = 0;
/*     */   
/*     */   public int max;
/*     */   public int min;
/* 259 */   private static int eMark = 0;
/* 260 */   private static int eClear = 0;
/* 261 */   private static int eFilter = 0;
/*     */ 
/*     */   
/*     */   private SelContext(String name) {}
/*     */ 
/*     */   
/*     */   public abstract T first();
/*     */ 
/*     */   
/*     */   public abstract T second();
/*     */   
/*     */   boolean init(Event abs) {
/* 273 */     this.am = 0;
/* 274 */     ESelection.ESelectionType<T> ss = sel(abs);
/* 275 */     eMark = ss.mark.mark ? (abs.allIndex + 1) : 0;
/* 276 */     eClear = 0;
/* 277 */     if (ss.mark.clear != null) {
/* 278 */       for (Event e : Event.all) {
/* 279 */         if (e.key.equals(ss.mark.clear)) {
/* 280 */           eClear = e.allIndex + 1;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/* 285 */     eFilter = 0;
/* 286 */     if (ss.mark.filter != null) {
/* 287 */       for (Event e : Event.all) {
/* 288 */         if (e.key.equals(ss.mark.filter)) {
/* 289 */           eFilter = e.allIndex + 1;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/* 295 */     int maxAm = max();
/*     */     
/* 297 */     if (maxAm <= 0) {
/* 298 */       return true;
/*     */     }
/*     */     
/* 301 */     for (int ei = 0; ei < maxAm; ei++) {
/* 302 */       T e = get(ei);
/* 303 */       if (e != null) {
/* 304 */         eventSet(e, 0);
/* 305 */         if (eClear != 0 && eClear == markGet(e)) {
/* 306 */           markSet(e, 0);
/*     */         }
/*     */         
/* 309 */         for (Lockable<T> l : ss.filters) {
/* 310 */           if (l.passes(e)) {
/*     */             
/* 312 */             this.am++;
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 318 */     this.max = ss.max.am(tot(), this.am);
/* 319 */     this.min = ss.min.am(tot(), this.am);
/*     */     
/* 321 */     if (this.am < this.min) {
/* 322 */       return false;
/*     */     }
/* 324 */     this.am = 0;
/*     */     
/* 326 */     T first = null;
/* 327 */     T second = null;
/*     */     
/* 329 */     int ri = RND.rInt(maxAm);
/*     */ 
/*     */ 
/*     */     
/* 333 */     for (int ii = 0; ii < maxAm; ii++) {
/* 334 */       int i = ii + ri;
/* 335 */       i %= maxAm;
/*     */       
/* 337 */       T e = get(i);
/*     */       
/* 339 */       if (e != null)
/*     */       {
/*     */         
/* 342 */         if (eFilter == 0 || 
/* 343 */           markGet(e) == eFilter)
/*     */         {
/*     */ 
/*     */           
/* 347 */           for (Lockable<T> l : ss.filters) {
/* 348 */             if (l.passes(e)) {
/* 349 */               if (this.am == 0) {
/* 350 */                 first = e;
/* 351 */               } else if (this.am == 1) {
/* 352 */                 second = e;
/*     */               } 
/* 354 */               this.am++;
/* 355 */               eventSet(e, 1);
/*     */               
/* 357 */               if (eMark != 0) {
/* 358 */                 markSet(e, eMark);
/*     */               }
/* 360 */               if (this.am >= this.max) {
/* 361 */                 set(first, second);
/* 362 */                 return true;
/*     */               } 
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       }
/*     */     } 
/* 370 */     set(first, second);
/* 371 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   abstract void set(T paramT1, T paramT2);
/*     */   
/*     */   int tot() {
/* 378 */     return max();
/*     */   }
/*     */ 
/*     */   
/*     */   abstract int max();
/*     */   
/*     */   abstract T get(int paramInt);
/*     */   
/*     */   abstract void markSet(T paramT, int paramInt);
/*     */   
/*     */   void copy(SelContext<T> o) {
/* 389 */     this.am = o.am;
/* 390 */     this.max = o.max;
/* 391 */     this.min = o.min;
/* 392 */     set(o.first(), o.second());
/*     */   }
/*     */   
/*     */   abstract int markGet(T paramT);
/*     */   
/*     */   abstract void eventSet(T paramT, int paramInt);
/*     */   
/*     */   abstract boolean eventGet(T paramT);
/*     */   
/*     */   abstract ESelection.ESelectionType<T> sel(Event paramEvent);
/*     */   
/*     */   abstract SPRITE sprite();
/*     */   
/*     */   abstract Class<?> cl();
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\engine\EContext$SelContext.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */