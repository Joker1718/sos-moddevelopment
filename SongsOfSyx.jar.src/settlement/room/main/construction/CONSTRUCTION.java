/*     */ package settlement.room.main.construction;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.ROOMS;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomState;
/*     */ import settlement.tilemap.TILE_FIXABLE;
/*     */ import settlement.tilemap.terrain.TBuilding;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import util.gui.misc.GBox;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ public final class CONSTRUCTION
/*     */ {
/*     */   final ConstructionBlueprint construction;
/*  27 */   private final Coo ctmp = new Coo();
/*     */   
/*     */   public MAP_BOOLEAN isser;
/*     */   
/*     */   public CONSTRUCTION(ROOMS m) {
/*  32 */     this.isser = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/*  36 */           return ((SETT.ROOMS()).map.blueprint.get(tx, ty) == CONSTRUCTION.this.construction);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/*  41 */           return ((SETT.ROOMS()).map.blueprint.get(tile) == CONSTRUCTION.this.construction);
/*     */         }
/*     */       };
/*     */     this.construction = new ConstructionBlueprint(m);
/*     */   }
/*     */   public void breakIt(TmpArea area, ConstructionInit init, int tx, int ty) {
/*  47 */     if (init.b.resources() == 0 && !init.b.mustBeIndoors() && !init.b.needFlooring()) {
/*  48 */       area.clear();
/*     */       
/*     */       return;
/*     */     } 
/*  52 */     ConstructionData.dBroken.set((ROOMA)area, tx, ty, 1);
/*  53 */     ConstructionData.dFloored.set((ROOMA)area, tx, ty, 0);
/*  54 */     FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty);
/*  55 */     if (it != null) {
/*  56 */       COORDINATE c = (SETT.ROOMS()).fData.itemX1Y1(tx, ty, this.ctmp);
/*  57 */       if (c != null) {
/*  58 */         for (int y = 0; y < it.height(); y++) {
/*  59 */           for (int x = 0; x < it.width(); x++) {
/*  60 */             if (it.get(x, y) != null) {
/*  61 */               int dx = x + c.x();
/*  62 */               int dy = y + c.y();
/*  63 */               if (area.is(dx, dy)) {
/*  64 */                 ConstructionData.dBroken.set((ROOMA)area, dx, dy, 1);
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  74 */     pcreate(area, init);
/*     */   }
/*     */   
/*     */   public void createClean(TmpArea area, ConstructionInit init) {
/*  78 */     for (COORDINATE c : area.body()) {
/*  79 */       if (!area.is(c))
/*     */         continue; 
/*  81 */       (SETT.ROOMS()).data.set((ROOMA)area, c.x(), c.y(), 0);
/*     */     } 
/*  83 */     pcreate(area, init);
/*     */   }
/*     */   
/*     */   public void createWithConstructionData(TmpArea area, ConstructionInit init) {
/*  87 */     for (COORDINATE c : area.body()) {
/*  88 */       if (!area.is(c))
/*     */         continue; 
/*  90 */       int d = ConstructionData.dData.get(c);
/*  91 */       (SETT.ROOMS()).data.set((ROOMA)area, c.x(), c.y(), 0);
/*  92 */       ConstructionData.dData.set((ROOMA)area, c, d);
/*     */     } 
/*  94 */     pcreate(area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   private void pcreate(TmpArea area, ConstructionInit init) {
/*  99 */     if (init.b.resources() == 0 && !init.b.mustBeIndoors() && !init.b.needFlooring()) {
/* 100 */       RoomInit i = new RoomInit(init.b.blue(), 0);
/*     */       
/* 102 */       ppCreate(area, i, init.b, init.upgrade, init.state);
/*     */     }
/*     */     else {
/*     */       
/* 106 */       this.construction.create(area, init);
/*     */     } 
/* 108 */     area.clear();
/*     */   }
/*     */   
/* 111 */   private static Rec tmp = new Rec();
/*     */ 
/*     */   
/*     */   static void ppCreate(TmpArea a, RoomInit init, Furnisher blueprint, int upgrade, RoomState state) {
/* 115 */     int x1 = a.mx();
/* 116 */     int y1 = a.my();
/* 117 */     tmp.set((BODY_HOLDER)a);
/* 118 */     blueprint.create(a, init);
/* 119 */     a.clear();
/*     */     
/* 121 */     Room r = (SETT.ROOMS()).map.get(x1, y1);
/* 122 */     r.upgradeSet(x1, y1, upgrade);
/* 123 */     if (state != null) {
/* 124 */       state.apply((SETT.ROOMS()).map.get(x1, y1), x1, y1);
/*     */     }
/*     */     
/* 127 */     if (r != null) {
/* 128 */       for (COORDINATE c : tmp) {
/* 129 */         if (r.isSame(x1, y1, c.x(), c.y()) && SETT.TERRAIN().get(c) instanceof TILE_FIXABLE) {
/* 130 */           ((TILE_FIXABLE)SETT.TERRAIN().get(c)).getTerrain(c.x(), c.y()).placeFixed(c.x(), c.y());
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRepair(int tx, int ty) {
/* 138 */     ConstructionInstance i = this.construction.get(tx, ty);
/* 139 */     return (i != null && i.broken);
/*     */   }
/*     */   
/*     */   public void construct(int tx, int ty) {
/* 143 */     this.construction.construct(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public TBuilding structure(int tx, int ty) {
/* 148 */     Room room = (SETT.ROOMS()).map.get(tx, ty);
/*     */     
/* 150 */     if (room instanceof ConstructionInstance) {
/* 151 */       return ((ConstructionInstance)room).structure();
/*     */     }
/* 153 */     return null;
/*     */   }
/*     */   
/*     */   public int instances() {
/* 157 */     return this.construction.all.size();
/*     */   }
/*     */   
/*     */   public int area(boolean countFarm) {
/* 161 */     int a = 0;
/* 162 */     for (ConstructionInstance i : this.construction.all) {
/* 163 */       if (i.blueprint == null)
/*     */         continue; 
/* 165 */       if (countFarm && i.blueprint.blue() instanceof settlement.room.food.farm.ROOM_FARM) {
/* 166 */         a = (int)(a + 0.1D * i.area()); continue;
/*     */       } 
/* 168 */       a += i.area();
/*     */     } 
/*     */     
/* 171 */     return a;
/*     */   }
/*     */   
/*     */   public void renderButt(SPRITE_RENDERER r, int x1, int cy, int ins) {
/* 175 */     if (ins >= 0 && ins < this.construction.all.size()) {
/* 176 */       ConstructionInstance i = (ConstructionInstance)this.construction.all.get(ins);
/* 177 */       this.construction.hoverer.renderButt(i, r, x1, cy);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void hoverButt(GBox box, int ins) {
/* 182 */     if (ins >= 0 && ins < this.construction.all.size()) {
/* 183 */       ConstructionInstance i = (ConstructionInstance)this.construction.all.get(ins);
/* 184 */       this.construction.hoverer.hover(box, (Room)i, i.mX(), i.mY());
/* 185 */       SETT.OVERLAY().add(i.mX(), i.mY());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void clickButt(int ins) {
/* 190 */     if (ins >= 0 && ins < this.construction.all.size()) {
/* 191 */       ConstructionInstance i = (ConstructionInstance)this.construction.all.get(ins);
/* 192 */       (VIEW.s().getWindow()).centererTile.set(i.body().cX(), i.body().cY());
/*     */     } 
/*     */   }
/*     */   
/*     */   public RoomState state(int tx, int ty) {
/* 197 */     if (this.isser.is(tx, ty)) {
/* 198 */       ConstructionInstance ins = (ConstructionInstance)(SETT.ROOMS()).map.get(tx, ty);
/* 199 */       return ins.state;
/*     */     } 
/* 201 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\construction\CONSTRUCTION.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */