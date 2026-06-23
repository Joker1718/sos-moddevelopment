/*     */ package view.sett.ui.room.construction;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.furnisher.FurnisherItemGroup;
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
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableFixed;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PlacerItemSingleArea
/*     */   extends PlacableMulti
/*     */ {
/*     */   private RoomBlueprintImp blueprint;
/* 145 */   private final ArrayList<CLICKABLE> li = new ArrayList(5);
/*     */   
/* 147 */   private final CLICKABLE bOverlay = (CLICKABLE)new GButt.ButtPanel((UI.icons()).s.eye.sized(24))
/*     */     {
/*     */       protected void clickA()
/*     */       {
/* 151 */         (SETT.ROOMS()).placement.placer.showOverlay.toggle();
/*     */       }
/*     */ 
/*     */       
/*     */       protected void renAction() {
/* 156 */         selectedSet((SETT.ROOMS()).placement.placer.showOverlay.is());
/*     */       }
/*     */ 
/*     */       
/*     */       public void hoverInfoGet(GUI_BOX text) {
/* 161 */         text.title(Dic.¤¤Overlay);
/* 162 */         (SETT.ROOMS()).placement.placer.structure.get();
/* 163 */         if (UIRoomPlacer.PlacerItemSingleArea.this.blueprint.constructor().overlay() != null && (UIRoomPlacer.PlacerItemSingleArea.this.blueprint.constructor().overlay()).desc != null) {
/* 164 */           text.text((UIRoomPlacer.PlacerItemSingleArea.this.blueprint.constructor().overlay()).desc);
/*     */         }
/*     */       }
/*     */     };
/*     */   
/* 169 */   private final CLICKABLE bFoundation = (CLICKABLE)new GButt.ButtPanel((SETT.OVERLAY()).FOUNDATION.icon.resized(24))
/*     */     {
/*     */       protected void clickA()
/*     */       {
/* 173 */         (SETT.ROOMS()).placement.placer.showFoundation.toggle();
/*     */       }
/*     */ 
/*     */       
/*     */       protected void renAction() {
/* 178 */         selectedSet((SETT.ROOMS()).placement.placer.showFoundation.is());
/*     */       }
/*     */ 
/*     */       
/*     */       public void hoverInfoGet(GUI_BOX text) {
/* 183 */         text.title((SETT.OVERLAY()).FOUNDATION.name);
/* 184 */         text.text((SETT.OVERLAY()).FOUNDATION.desc);
/*     */       }
/*     */     };
/*     */   
/*     */   public PlacerItemSingleArea() {
/* 189 */     super("");
/*     */   }
/*     */   
/*     */   public void set(RoomBlueprintImp b) {
/* 193 */     this.blueprint = b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence name() {
/* 199 */     return this.blueprint.info.names;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 204 */     return init().placable(tx, ty, 0, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 209 */     init().place(tx, ty, 0, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public PLACABLE getUndo() {
/* 214 */     return init().getUndo();
/*     */   }
/*     */ 
/*     */   
/*     */   public void placeInfo(GBox b, int oktiles, AREA a) {
/* 219 */     for (int i = 0; i < this.blueprint.constructor().resources(); i++) {
/* 220 */       if (((FurnisherItemGroup)this.blueprint.constructor().groups().get(0)).item(0, 0).cost2(i, 0) > 0.0D) {
/* 221 */         b.setResource(this.blueprint.constructor().resource(i), oktiles * Math.ceil(((FurnisherItemGroup)this.blueprint.constructor().groups().get(0)).item(0, 0).cost2(i, 0)));
/* 222 */         b.space();
/*     */       } 
/*     */     } 
/* 225 */     super.placeInfo(b, oktiles, a);
/*     */   }
/*     */   
/*     */   private PlacableFixed init() {
/* 229 */     UIRoomPlacer.this.state.placement.placer.init(this.blueprint, 0);
/* 230 */     PlacableFixed pp = UIRoomPlacer.this.state.placement.placer.item(0);
/* 231 */     return pp;
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateRegardless(GameWindow window, AREA selected) {
/* 236 */     if (this.blueprint.constructor().overlay() != null && UIRoomPlacer.this.state.placement.placer.showOverlay.is())
/* 237 */       this.blueprint.constructor().overlay().add(); 
/* 238 */     if (this.blueprint.constructor().isHeavy() && UIRoomPlacer.this.state.placement.placer.showFoundation.is()) {
/* 239 */       (SETT.OVERLAY()).FOUNDATION.add();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, AREA area, PLACER_TYPE type, boolean isPlacable, boolean areaIsPlacable) {
/* 245 */     super.renderPlaceHolder(r, mask, x, y, tx, ty, area, type, isPlacable, areaIsPlacable);
/* 246 */     this.blueprint.constructor().renderExtra(r, x, y, tx, ty, 0, 0, ((FurnisherItemGroup)this.blueprint.constructor().groups().get(0)).item(0, 0));
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<CLICKABLE> getAdditionalButt() {
/* 251 */     this.li.clearSloppy();
/* 252 */     if (this.blueprint.constructor().overlay() != null)
/* 253 */       this.li.add(this.bOverlay); 
/* 254 */     if (this.blueprint.constructor().isHeavy())
/* 255 */       this.li.add(this.bFoundation); 
/* 256 */     return super.getAdditionalButt();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\UIRoomPlacer$PlacerItemSingleArea.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */