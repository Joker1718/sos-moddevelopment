/*     */ package settlement.thing;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.room.main.Room;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ThingPlacer
/*     */ {
/*     */   static void init() {
/*  25 */     LinkedList<PLACABLE> pl = new LinkedList();
/*  26 */     for (RESOURCE r : RESOURCES.ALL()) {
/*  27 */       pl.add(new PlacableMulti(r.name)
/*     */           {
/*     */             public void place(int tx, int ty, AREA a, PLACER_TYPE t)
/*     */             {
/*  31 */               (SETT.THINGS()).resources.createPrecise(tx, ty, r, 1 + RND.rInt(29));
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/*  37 */               return null;
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */     
/*  43 */     pl.add(new PlacableMulti("resources all")
/*     */         {
/*  45 */           int ri = 0;
/*     */ 
/*     */           
/*     */           public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  49 */             (SETT.THINGS()).resources.createPrecise(tx, ty, (RESOURCE)RESOURCES.ALL().get(this.ri), 64);
/*  50 */             this.ri++;
/*  51 */             this.ri %= RESOURCES.ALL().size();
/*     */           }
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE type) {
/*  56 */             return null;
/*     */           }
/*     */         });
/*     */     
/*  60 */     pl.add(new PlacableMulti("resource increase")
/*     */         {
/*     */           public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */           {
/*  64 */             for (THINGS.Thing t : SETT.THINGS().get(tx, ty)) {
/*  65 */               if (t instanceof ThingsResources.ScatteredResource) {
/*  66 */                 int a = ((ThingsResources.ScatteredResource)t).amount();
/*  67 */                 a -= a / 10 * 10;
/*  68 */                 a = 10 - a;
/*  69 */                 if (((ThingsResources.ScatteredResource)t).amount() + a < 10000) {
/*  70 */                   (SETT.THINGS()).resources.createPrecise(tx, ty, ((ThingsResources.ScatteredResource)t).resource(), a);
/*     */                 }
/*     */                 return;
/*     */               } 
/*     */             } 
/*     */           }
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE type) {
/*  78 */             for (THINGS.Thing t : SETT.THINGS().get(tx, ty)) {
/*  79 */               if (t instanceof ThingsResources.ScatteredResource)
/*  80 */                 return null; 
/*     */             } 
/*  82 */             return "";
/*     */           }
/*     */         });
/*     */     
/*  86 */     pl.add(new PlacableMulti("increase crate")
/*     */         {
/*     */           public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */           {
/*  90 */             Room r = (SETT.ROOMS()).map.get(tx, ty);
/*  91 */             if (r != null) {
/*  92 */               TILE_STORAGE c = (TILE_STORAGE)(SETT.MAPS()).STORAGE.get(tx, ty);
/*  93 */               for (int i = 0; i < 16 && c.resource() != null && c != null && c.storageReservable() > 0; i++) {
/*  94 */                 c.storageReserve(1);
/*  95 */                 c.storageDeposit(1);
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE type) {
/* 104 */             if ((SETT.MAPS()).STORAGE.get(tx, ty) != null) {
/* 105 */               return null;
/*     */             }
/* 107 */             return "";
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     pl.add(new PlacableMulti("remove things")
/*     */         {
/*     */           public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */           {
/* 118 */             LISTE<THINGS.Thing> lISTE = SETT.THINGS().get(tx, ty);
/* 119 */             if (!lISTE.isEmpty()) {
/* 120 */               ((THINGS.Thing)lISTE.get(0)).remove();
/*     */             }
/*     */           }
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE type) {
/* 125 */             LISTE<THINGS.Thing> lISTE = SETT.THINGS().get(tx, ty);
/* 126 */             if (lISTE.isEmpty())
/* 127 */               return ""; 
/* 128 */             return null;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 133 */     IDebugPanelSett.add("resources", (Iterable)pl);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\ThingPlacer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */