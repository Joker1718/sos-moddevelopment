/*     */ package view.sett.ui.subject;
/*     */ 
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.type.HTYPES;
/*     */ import java.util.Comparator;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import util.GUTIL;
/*     */ import world.army.AD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Li
/*     */ {
/* 246 */   private final Bitmap1D race = new Bitmap1D(RACES.all().size(), false);
/* 247 */   private Bitmap1D type = new Bitmap1D(HTYPES.ALL().size(), false);
/*     */   private boolean favorite = false;
/*     */   private boolean soldier = false;
/*     */   private UISubjectsList.SSort sort;
/* 251 */   private RoomInstance fWork = null;
/*     */   private UISubjectsList.SSort wSort;
/* 253 */   private int favos = 0;
/* 254 */   private int sols = 0;
/* 255 */   private final ArrayList<Object> li = GUTIL.hList();
/*     */ 
/*     */   
/*     */   private final Comparator<Object> sorter;
/*     */ 
/*     */ 
/*     */   
/*     */   Li() {
/* 263 */     this.sorter = new Comparator()
/*     */       {
/*     */         
/*     */         public int compare(Object o1, Object o2)
/*     */         {
/* 268 */           Induvidual i1 = (o1 instanceof Humanoid) ? ((Humanoid)o1).indu() : (Induvidual)o1;
/* 269 */           Induvidual i2 = (o2 instanceof Humanoid) ? ((Humanoid)o2).indu() : (Induvidual)o2;
/* 270 */           double a = UISubjectsList.Li.this.sort.vale(i1, i2);
/* 271 */           if (a == 0.0D)
/* 272 */             return 0; 
/* 273 */           return (a < 0.0D) ? -1 : 1; }
/*     */       };
/*     */     this.race.setAll(true);
/*     */     this.type.setAll(true);
/*     */   } void sort() {
/* 278 */     this.favos = 0;
/* 279 */     this.sols = 0;
/* 280 */     this.li.clearSloppy();
/* 281 */     ENTITY[] es = SETT.ENTITIES().getAllEnts();
/* 282 */     int ee = SETT.ENTITIES().Imax();
/* 283 */     if (this.fWork != null) {
/* 284 */       for (int i = 0; i <= ee; i++) {
/* 285 */         ENTITY e = es[i];
/*     */         
/* 287 */         if (e instanceof Humanoid) {
/* 288 */           Humanoid h = (Humanoid)e;
/* 289 */           this.favos += (STATS.APPEARANCE()).favo.get(h.indu());
/* 290 */           if ((STATS.WORK()).EMPLOYED.get(h) == this.fWork) {
/* 291 */             this.li.add(h);
/*     */           }
/*     */         } 
/*     */       } 
/* 295 */       UISubjectsList.SSort o = this.sort;
/* 296 */       this.sort = this.wSort;
/* 297 */       this.li.sort(this.sorter);
/* 298 */       this.sort = o;
/*     */     } else {
/* 300 */       for (int i = 0; i < ee; i++) {
/* 301 */         ENTITY e = es[i];
/* 302 */         if (e instanceof Humanoid) {
/* 303 */           Humanoid h = (Humanoid)e;
/* 304 */           this.favos += (STATS.APPEARANCE()).favo.get(h.indu());
/* 305 */           if (this.race.get((h.race()).index) && this.type.get(h.indu().hType().index()) && (
/* 306 */             !this.favorite || (STATS.APPEARANCE()).favo.get(h.indu()) != 0))
/*     */           {
/* 308 */             this.li.add(h);
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 314 */       for (int di = 0; di < (Config.battle()).DIVISIONS_PER_ARMY; di++) {
/* 315 */         int m = AD.cityDivs().soldiers(di);
/* 316 */         this.sols += m;
/* 317 */         if (this.soldier) {
/* 318 */           for (int j = 0; j < m; j++) {
/* 319 */             Induvidual ii = AD.cityDivs().getSoldier(j, di);
/* 320 */             this.li.add(ii);
/* 321 */             this.favos += (STATS.APPEARANCE()).favo.get(ii);
/*     */           } 
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 329 */       this.li.sort(this.sorter);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectsList$Li.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */