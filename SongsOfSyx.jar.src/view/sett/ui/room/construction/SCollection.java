/*     */ package view.sett.ui.room.construction;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.furnisher.FurnisherItemGroup;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.bottom.UIRoomBuild;
/*     */ 
/*     */ final class SCollection {
/*  18 */   private final IButt[] butts = new IButt[32]; private final State state;
/*  19 */   private final IIButt[] item = new IIButt[32];
/*     */ 
/*     */   
/*  22 */   private GuiSection section = new GuiSection();
/*  23 */   private GuiSection isection = new GuiSection();
/*     */   SCollection(State state) {
/*  25 */     this.state = state;
/*     */     
/*  27 */     for (int i = 0; i < this.butts.length; i++) {
/*  28 */       this.butts[i] = new IButt(state, i);
/*  29 */       this.item[i] = new IIButt(state, i);
/*     */     } 
/*     */   }
/*     */   
/*     */   GuiSection get() {
/*  34 */     this.section.clear();
/*  35 */     if (this.state.collection == null || this.state.collection.rooms().size() == 0)
/*  36 */       return this.section;  int i;
/*  37 */     for (i = 0; i < this.state.collection.rooms().size(); i++) {
/*  38 */       this.section.addGrid((RENDEROBJ)this.butts[i], i, 8, 0, 0);
/*     */     }
/*  40 */     this.isection.clear();
/*     */     
/*  42 */     if (this.state.b.constructor().groups().size() > 1)
/*  43 */       for (i = 0; i < this.state.b.constructor().groups().size(); i++) {
/*  44 */         this.isection.addGrid((RENDEROBJ)this.item[i], i, 2, 0, 0);
/*     */       } 
/*  46 */     this.section.addRelBody(2, DIR.S, (RENDEROBJ)this.isection);
/*     */     
/*  48 */     return this.section;
/*     */   }
/*     */   
/*     */   static class IButt extends GButt.ButtPanel {
/*     */     private final State state;
/*     */     private final int k;
/*     */     
/*     */     IButt(State state, int k) {
/*  56 */       super((SPRITE)new SPRITE.Imp(32, state, k)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */             {
/*  60 */               RoomBlueprintImp b = (RoomBlueprintImp)state.collection.rooms().get(k);
/*  61 */               b.iconBig().render(r, X1, X2, Y1, Y2);
/*     */             }
/*     */           });
/*     */       
/*  65 */       this.state = state;
/*  66 */       this.k = k;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void renAction() {
/*  71 */       RoomBlueprintImp b = (RoomBlueprintImp)this.state.collection.rooms().get(this.k);
/*  72 */       activeSet((b != null && b.reqs.passes(FACTIONS.player())));
/*  73 */       selectedSet((this.state.b == this.state.collection.rooms().get(this.k)));
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/*  78 */       (VIEW.s()).ui.placer.init((RoomBlueprintImp)this.state.collection.rooms().get(this.k), this.state.collection);
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/*  83 */       UIRoomBuild.hoverRoomBuild((RoomBlueprintImp)this.state.collection.rooms().get(this.k), text);
/*     */     }
/*     */   }
/*     */   
/*     */   static class IIButt
/*     */     extends GButt.ButtPanel {
/*     */     private final State state;
/*     */     private final int k;
/*     */     
/*     */     IIButt(State state, int k) {
/*  93 */       super((SPRITE)new SPRITE.Imp(175, (UI.FONT()).S.height(), state, k)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */             {
/*  97 */               RoomBlueprintImp b = state.b;
/*  98 */               (UI.FONT()).S.renderCropped(r, ((FurnisherItemGroup)b.constructor().groups().getC(k)).name, X1, Y1, 175);
/*     */             }
/*     */           });
/*     */       
/* 102 */       this.state = state;
/* 103 */       this.k = k;
/* 104 */       pad(2, 1);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void renAction() {
/* 109 */       selectedSet((this.state.item() == this.k));
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 114 */       this.state.setItem(this.k);
/* 115 */       (VIEW.s()).ui.placer.init(this.state.b, this.state.collection);
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 120 */       RoomBlueprintImp b = this.state.b;
/* 121 */       text.title(((FurnisherItemGroup)b.constructor().groups().getC(this.k)).name);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SCollection.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */