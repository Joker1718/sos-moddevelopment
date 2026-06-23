/*     */ package view.sett.ui.room.construction;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemGroup;
/*     */ import settlement.room.main.util.RoomState;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableFixed;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UIRoomPlacer
/*     */ {
/*  34 */   private final State state = new State();
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(RoomBlueprintImp b, int tx, int ty) {
/*  39 */     if (b.cat == (SETT.ROOMS()).CATS.DECOR) {
/*  40 */       this.state.init(b, b.cat);
/*     */     } else {
/*  42 */       this.state.init(b, false);
/*     */     } 
/*  44 */     this.state.placement.placer.init(b, 0);
/*  45 */     if (b.constructor().usesArea()) {
/*  46 */       (VIEW.s()).tools.place(this.state.placement.placer.area(), this.state.config);
/*     */     } else {
/*  48 */       if (b.constructor().isSpecialAreaPlacable()) {
/*  49 */         if (b.constructor().groups().size() == 1 && ((FurnisherItemGroup)b.constructor().groups().get(0)).rotations() == 1 && b.constructor().groups().size() == 1) {
/*  50 */           if (b.employment() == null) {
/*  51 */             this.ipla.set(b);
/*  52 */             (VIEW.s()).tools.place((PLACABLE)this.ipla, null);
/*     */             return;
/*     */           } 
/*     */         } else {
/*  56 */           throw new RuntimeException();
/*     */         } 
/*     */       }
/*     */       
/*  60 */       FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty);
/*  61 */       if (it != null) {
/*  62 */         PlacableFixed pp = this.state.placement.placer.item(it.group.index());
/*  63 */         pp.rotSet(it.rotation);
/*  64 */         int size = 0;
/*  65 */         for (int i = 0; i < it.group.size(); i++) {
/*  66 */           if (it.group.item(i, it.rotation) == it) {
/*  67 */             size = i;
/*     */             break;
/*     */           } 
/*     */         } 
/*  71 */         pp.sizeSet(size);
/*  72 */         this.state.setItem(it.group().index());
/*  73 */         (VIEW.s()).tools.place((PLACABLE)pp, this.state.config);
/*     */       } else {
/*  75 */         PlacableFixed pp = this.state.placement.placer.item(this.state.item());
/*  76 */         (VIEW.s()).tools.place((PLACABLE)pp, this.state.config);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(RoomBlueprintImp b, RoomCategorySub bb) {
/*  84 */     this.state.init(b, bb);
/*     */     
/*  86 */     this.state.placement.placer.init(b, 0);
/*  87 */     if (b.constructor().usesArea()) {
/*  88 */       (VIEW.s()).tools.place(this.state.placement.placer.area(), this.state.config);
/*     */     } else {
/*  90 */       PlacableFixed pp = this.state.placement.placer.item(this.state.item());
/*  91 */       (VIEW.s()).tools.place((PLACABLE)pp, this.state.config);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void init(Room.RoomInstanceImp ins) {
/*  96 */     this.state.init(ins.constructor().blue(), true);
/*     */     
/*  98 */     RoomBlueprintImp b = ins.constructor().blue();
/*  99 */     RoomState stat = ins.makeState(ins.mX(), ins.mY(), false);
/* 100 */     int up = ins.upgrade();
/* 101 */     int deg = (ins.degrader(ins.mX(), ins.mY()) == null) ? 0 : ins.degrader(ins.mX(), ins.mY()).getData();
/* 102 */     TmpArea a = ins.remove(ins.mX(), ins.mY(), false, this, false);
/* 103 */     if (a == null)
/*     */       return; 
/* 105 */     if (a.area() <= 0) {
/* 106 */       a.clear();
/*     */       
/*     */       return;
/*     */     } 
/* 110 */     (SETT.ROOMS()).placement.placer.reconstruct(a, up, deg, stat, b);
/*     */     
/* 112 */     (VIEW.s()).tools.place(this.state.placement.placer.area(), this.state.config);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(int tx, int ty) {
/* 118 */     if (this.state.placement.canReconstruct(tx, ty)) {
/* 119 */       Room.RoomInstanceImp r = (Room.RoomInstanceImp)(SETT.ROOMS()).map.get(tx, ty);
/* 120 */       init(r);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isActive(RoomBlueprintImp b) {
/* 126 */     return ((VIEW.s()).tools.configCurrent() == this.state.config && b == this.state.b);
/*     */   }
/*     */   
/*     */   public boolean isActive() {
/* 130 */     return ((VIEW.s()).tools.configCurrent() == this.state.config);
/*     */   }
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 134 */     if ((VIEW.s()).tools.configCurrent() == this.state.config) {
/* 135 */       return this.state.b;
/*     */     }
/* 137 */     return null;
/*     */   }
/*     */   
/* 140 */   private final PlacerItemSingleArea ipla = new PlacerItemSingleArea();
/*     */   
/*     */   private class PlacerItemSingleArea
/*     */     extends PlacableMulti {
/*     */     private RoomBlueprintImp blueprint;
/* 145 */     private final ArrayList<CLICKABLE> li = new ArrayList(5);
/*     */     
/* 147 */     private final CLICKABLE bOverlay = (CLICKABLE)new GButt.ButtPanel((UI.icons()).s.eye.sized(24))
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 151 */           (SETT.ROOMS()).placement.placer.showOverlay.toggle();
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 156 */           selectedSet((SETT.ROOMS()).placement.placer.showOverlay.is());
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 161 */           text.title(Dic.¤¤Overlay);
/* 162 */           (SETT.ROOMS()).placement.placer.structure.get();
/* 163 */           if (UIRoomPlacer.PlacerItemSingleArea.this.blueprint.constructor().overlay() != null && (UIRoomPlacer.PlacerItemSingleArea.this.blueprint.constructor().overlay()).desc != null) {
/* 164 */             text.text((UIRoomPlacer.PlacerItemSingleArea.this.blueprint.constructor().overlay()).desc);
/*     */           }
/*     */         }
/*     */       };
/*     */     
/* 169 */     private final CLICKABLE bFoundation = (CLICKABLE)new GButt.ButtPanel((SETT.OVERLAY()).FOUNDATION.icon.resized(24))
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 173 */           (SETT.ROOMS()).placement.placer.showFoundation.toggle();
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 178 */           selectedSet((SETT.ROOMS()).placement.placer.showFoundation.is());
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 183 */           text.title((SETT.OVERLAY()).FOUNDATION.name);
/* 184 */           text.text((SETT.OVERLAY()).FOUNDATION.desc);
/*     */         }
/*     */       };
/*     */     
/*     */     public PlacerItemSingleArea() {
/* 189 */       super("");
/*     */     }
/*     */     
/*     */     public void set(RoomBlueprintImp b) {
/* 193 */       this.blueprint = b;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public CharSequence name() {
/* 199 */       return this.blueprint.info.names;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 204 */       return init().placable(tx, ty, 0, 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 209 */       init().place(tx, ty, 0, 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public PLACABLE getUndo() {
/* 214 */       return init().getUndo();
/*     */     }
/*     */ 
/*     */     
/*     */     public void placeInfo(GBox b, int oktiles, AREA a) {
/* 219 */       for (int i = 0; i < this.blueprint.constructor().resources(); i++) {
/* 220 */         if (((FurnisherItemGroup)this.blueprint.constructor().groups().get(0)).item(0, 0).cost2(i, 0) > 0.0D) {
/* 221 */           b.setResource(this.blueprint.constructor().resource(i), oktiles * Math.ceil(((FurnisherItemGroup)this.blueprint.constructor().groups().get(0)).item(0, 0).cost2(i, 0)));
/* 222 */           b.space();
/*     */         } 
/*     */       } 
/* 225 */       super.placeInfo(b, oktiles, a);
/*     */     }
/*     */     
/*     */     private PlacableFixed init() {
/* 229 */       UIRoomPlacer.this.state.placement.placer.init(this.blueprint, 0);
/* 230 */       PlacableFixed pp = UIRoomPlacer.this.state.placement.placer.item(0);
/* 231 */       return pp;
/*     */     }
/*     */ 
/*     */     
/*     */     public void updateRegardless(GameWindow window, AREA selected) {
/* 236 */       if (this.blueprint.constructor().overlay() != null && UIRoomPlacer.this.state.placement.placer.showOverlay.is())
/* 237 */         this.blueprint.constructor().overlay().add(); 
/* 238 */       if (this.blueprint.constructor().isHeavy() && UIRoomPlacer.this.state.placement.placer.showFoundation.is()) {
/* 239 */         (SETT.OVERLAY()).FOUNDATION.add();
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, AREA area, PLACER_TYPE type, boolean isPlacable, boolean areaIsPlacable) {
/* 245 */       super.renderPlaceHolder(r, mask, x, y, tx, ty, area, type, isPlacable, areaIsPlacable);
/* 246 */       this.blueprint.constructor().renderExtra(r, x, y, tx, ty, 0, 0, ((FurnisherItemGroup)this.blueprint.constructor().groups().get(0)).item(0, 0));
/*     */     }
/*     */ 
/*     */     
/*     */     public LIST<CLICKABLE> getAdditionalButt() {
/* 251 */       this.li.clearSloppy();
/* 252 */       if (this.blueprint.constructor().overlay() != null)
/* 253 */         this.li.add(this.bOverlay); 
/* 254 */       if (this.blueprint.constructor().isHeavy())
/* 255 */         this.li.add(this.bFoundation); 
/* 256 */       return super.getAdditionalButt();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void reconstruct(RoomInstance r) {
/* 263 */     init((Room.RoomInstanceImp)r);
/*     */   }
/*     */   
/*     */   public void reconstruct(int tx, int ty) {
/* 267 */     init(tx, ty);
/*     */   }
/*     */   
/*     */   public void reconstruct(RoomBlueprintImp b) {
/* 271 */     init(b, -1, -1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\UIRoomPlacer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */