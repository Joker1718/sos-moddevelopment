/*     */ package settlement.room.main.placement;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.construction.ConstructionData;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.GUTIL;
/*     */ import util.data.AreaTmp;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMessages;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ class PlacerItemArea extends PlacerItemSingle {
/*  24 */   private static CharSequence ¤¤undo = "¤Remove Item";
/*     */   static {
/*  26 */     D.ts(PlacerItemArea.class);
/*     */   }
/*     */   
/*  29 */   private final PlacableMulti undo = new PlacableMulti(¤¤undo)
/*     */     {
/*     */       public void place(int x1, int y1, AREA a, PLACER_TYPE t)
/*     */       {
/*  33 */         PlacerItemArea.this.removeItem(x1, y1);
/*     */       }
/*     */ 
/*     */       
/*     */       public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/*  38 */         if (!PlacerItemArea.this.area.is(tx, ty) || !(SETT.ROOMS()).fData.item.is(tx, ty)) {
/*  39 */           return PlacableMessages.¤¤ITEM_MUST;
/*     */         }
/*  41 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/*  46 */         if (!PlacerItemArea.this.area.is(fromX, fromY) || !PlacerItemArea.this.area.is(toX, toY))
/*  47 */           return false; 
/*  48 */         FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(fromX, fromY);
/*  49 */         FurnisherItem it2 = (FurnisherItem)(SETT.ROOMS()).fData.item.get(toX, toY);
/*  50 */         if (it != null && it2 != null) {
/*  51 */           COORDINATE c = (SETT.ROOMS()).fData.itemMaster(fromX, fromY, Coo.TMP);
/*  52 */           int x = c.x();
/*  53 */           int y = c.y();
/*  54 */           return (SETT.ROOMS()).fData.itemMaster(toX, toY, Coo.TMP).isSameAs(x, y);
/*     */         } 
/*  56 */         return false;
/*     */       }
/*     */     };
/*     */   
/*     */   public void removeItem(int x1, int y1) {
/*  61 */     if (!this.embryo.instance.is(x1, y1)) {
/*     */       return;
/*     */     }
/*  64 */     FurnisherItem item = (FurnisherItem)(SETT.ROOMS()).fData.item.get(x1, y1);
/*  65 */     if (item == null) {
/*     */       return;
/*     */     }
/*  68 */     COORDINATE c = (SETT.ROOMS()).fData.itemX1Y1(x1, y1, Coo.TMP);
/*  69 */     int x11 = c.x();
/*  70 */     int y11 = c.y();
/*     */     
/*  72 */     boolean constructed = ConstructionData.dConstructed.is(x1, y1, 1); int dy;
/*  73 */     for (dy = 0; dy < item.height(); dy++) {
/*  74 */       for (int dx = 0; dx < item.width(); dx++) {
/*  75 */         if (item.get(dx, dy) != null && 
/*  76 */           !this.embryo.instance.is(x11 + dx, y11 + dy)) {
/*  77 */           debug(x1, y1);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  85 */     for (dy = 0; dy < item.height(); dy++) {
/*  86 */       for (int dx = 0; dx < item.width(); dx++) {
/*  87 */         if (item.get(dx, dy) != null) {
/*  88 */           ConstructionData.dConstructed.set((ROOMA)this.embryo.instance, x11 + dx, y11 + dy, 0);
/*     */         }
/*     */       } 
/*     */     } 
/*  92 */     (SETT.ROOMS()).fData.itemClear(x1, y1, (Room)this.embryo.instance);
/*     */     
/*  94 */     this.embryo.history.placeItem(item, x11, y11, -1);
/*     */     
/*  96 */     if (constructed) {
/*  97 */       this.embryo.resources.removeItem(x1, y1, item);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void debug(int x1, int y1) {
/* 103 */     FurnisherItem item = (FurnisherItem)(SETT.ROOMS()).fData.item.get(x1, y1);
/* 104 */     COORDINATE c = (SETT.ROOMS()).fData.itemX1Y1(x1, y1, Coo.TMP);
/* 105 */     int x11 = c.x();
/* 106 */     int y11 = c.y();
/*     */     
/* 108 */     System.err.println("so, here we go again... Item is " + (item.group.blueprint.blue()).key + " " + item.group.index() + " " + item.width() + " " + item.height());
/* 109 */     System.err.println("coo: " + x1 + " " + y1);
/* 110 */     System.err.println("embrio: " + String.valueOf(this.embryo.instance.body()));
/*     */     
/* 112 */     System.err.println("the x1y1: " + String.valueOf(c));
/*     */     
/* 114 */     for (int dy = 0; dy < item.height(); dy++) {
/* 115 */       for (int dx = 0; dx < item.width(); dx++) {
/* 116 */         if (item.get(dx, dy) != null && 
/* 117 */           !this.embryo.instance.is(x11 + dx, y11 + dy)) {
/* 118 */           System.err.println("" + dx + " " + dx + " " + dy + " " + x11 + dx);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 125 */     throw new RuntimeException("Game has crashed because there is some weirdness when deleting items. Please, try to remember how you furnished the room before you deleted the items, and try and recreate the crash, so that this bug can be found and squashed. Type it in the message, but even better, compose an email to: info@songsofsyx.com");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, int rx, int ry, boolean isPlacable, boolean areaIsPlacable) {
/* 131 */     boolean b = this.embryo.autoWalls.getBool();
/* 132 */     this.embryo.autoWalls.set(false);
/* 133 */     super.renderPlaceHolder(r, mask, x, y, tx, ty, rx, ry, isPlacable, areaIsPlacable);
/* 134 */     this.embryo.autoWalls.set(b);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PlacerItemArea(RoomPlacer embryo) {
/* 140 */     super(embryo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty, int rx, int ry) {
/* 150 */     if (rx == 0 && ry == 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 159 */       FurnisherItem it = this.group.item(size(), rot());
/* 160 */       (SETT.ROOMS()).fData.itemSet(tx, ty, it, this.embryo.instance);
/* 161 */       this.embryo.history.placeItem(it, tx, ty, 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence placableWhole(int tx1, int ty1) {
/* 184 */     return this.embryo.placability.itemProblem(tx1, ty1, this.group, this.group.item(size(), rot()), (AREA)this.embryo.instance);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence placable(int tx, int ty, int rx, int ry) {
/* 189 */     return this.embryo.placability.itemPlacable(tx, ty, rx, ry, this.group.item(size(), rot()), (AREA)this.embryo.instance);
/*     */   }
/*     */ 
/*     */   
/*     */   public void placeInfo(GBox box, int x1, int y1) {
/* 194 */     box.add((SPRITE)box.text().add(width()).add('x').add(height()));
/* 195 */     box.NL();
/* 196 */     for (int i = 0; i < this.group.blueprint.resources(); i++) {
/* 197 */       if (this.group.item(size(), rot()).cost2(i, this.embryo.instance.upgrade()) > 0.0D) {
/* 198 */         box.setResource(this.group.blueprint.resource(i), this.group.item(size(), rot()).cost2(i, this.embryo.instance.upgrade()));
/* 199 */         box.space();
/*     */       } 
/*     */     } 
/*     */     
/* 203 */     for (FurnisherStat s : this.group.blueprint.stats()) {
/* 204 */       double am = this.embryo.resources.statIncr(this.group.item(size(), rot()), s);
/* 205 */       if (am != 0.0D) {
/* 206 */         box.NL();
/* 207 */         box.add((SPRITE)box.text().lablify().add(s.name()));
/* 208 */         box.tab(7);
/* 209 */         box.add((SPRITE)GFORMAT.f0(box.text(), am));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PLACABLE getUndo() {
/* 218 */     return (PLACABLE)this.undo;
/*     */   }
/*     */ 
/*     */   
/*     */   public AREA getTmpArea(int x1, int y1, FurnisherItem item) {
/* 223 */     AreaTmp a = GUTIL.AREA();
/* 224 */     a.clear();
/*     */     int y;
/* 226 */     for (y = 0; y < item.height(); y++) {
/* 227 */       for (int x = 0; x < item.width(); x++) {
/* 228 */         if (item.is(x, y)) {
/*     */ 
/*     */ 
/*     */           
/* 232 */           int tx = x + x1;
/* 233 */           int ty = y + y1;
/*     */           
/* 235 */           if (!this.embryo.instance.is(tx, ty)) {
/* 236 */             a.set(tx, ty);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 242 */     for (y = -1; y <= item.height(); y++) {
/* 243 */       for (int x = -1; x <= item.width(); x++) {
/* 244 */         if (!item.is(x, y))
/*     */         {
/*     */ 
/*     */           
/* 248 */           for (DIR d : DIR.ALL) {
/* 249 */             int dx = x + d.x();
/* 250 */             int dy = y + d.y();
/* 251 */             if (item.is(dx, dy) && (item.get(dx, dy)).mustBeReachable) {
/* 252 */               int tx = x + x1;
/* 253 */               int ty = y + y1;
/* 254 */               if (!this.embryo.instance.is(tx, ty)) {
/* 255 */                 a.set(tx, ty);
/*     */               }
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 263 */     return (AREA)a;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\PlacerItemArea.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */