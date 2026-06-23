/*     */ package settlement.room.infra.logistics;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.GameDisposable;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class MoveOrderPullersUI
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   private static ArrayList<RoomInstance> ins;
/*  33 */   private static CharSequence ¤¤pullers = "Pullers";
/*     */ 
/*     */   
/*     */   private final GuiSection pop;
/*     */ 
/*     */   
/*     */   private final GETTER<? extends RoomInstance> g;
/*     */ 
/*     */   
/*     */   private int upI;
/*     */ 
/*     */   
/*     */   static {
/*  46 */     D.ts(MoveOrderPullersUI.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MoveOrderPullersUI(GETTER<? extends RoomInstance> g) {
/*  54 */     super((SPRITE)(UI.icons()).m.storage_pullers);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 126 */     this.upI = -1; this.g = g; this.body.setDim(48.0D); GTableBuilder bu = new GTableBuilder() { public int nrOFEntries() { return MoveOrderPullersUI.this.all().size(); } }
/*     */       ; bu.column(400, new GTableBuilder.GRowBuilder() { public RENDEROBJ build(final GETTER<Integer> ier) { SPRITE.Imp imp = new SPRITE.Imp(400, 32) { public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) { RoomInstance ins = (RoomInstance)MoveOrderPullersUI.null.access$0(MoveOrderPullersUI.null.this).all().get(((Integer)ier.get()).intValue()); if (ins != null) { ins.icon().render(r, X1, Y1); (GCOLOR.T()).H1.bind(); (UI.FONT()).H2.render(r, (CharSequence)ins.name(), X1 + 48, Y1 + 16 - (UI.FONT()).H2.height() / 2); }  } }; return (RENDEROBJ)new GButt.ButtPanel((SPRITE)imp) { protected void clickA() { RoomInstance ins = (RoomInstance)MoveOrderPullersUI.null.access$0(MoveOrderPullersUI.null.this).all().get(((Integer)ier.get()).intValue()); if (ins != null) (VIEW.s().getWindow()).centererTile.set(ins.body().cX(), ins.body().cY());  } }; } }
/*     */         DIR.NW); this.pop = new GuiSection(); this.pop.add((RENDEROBJ)bu.create(20, false));
/* 129 */   } private LIST<RoomInstance> all() { if (ins == null) {
/* 130 */       ins = new ArrayList(100);
/*     */     }
/* 132 */     if (this.upI == GAME.updateI()) {
/* 133 */       return (LIST<RoomInstance>)ins;
/*     */     }
/* 135 */     ins.clearSloppy();
/* 136 */     RoomInstance tar = (RoomInstance)this.g.get();
/* 137 */     for (RoomBlueprint b : SETT.ROOMS().all()) {
/* 138 */       if (b instanceof RoomBlueprintIns) {
/* 139 */         RoomBlueprintIns<?> bb = (RoomBlueprintIns)b;
/* 140 */         if (bb.instancesSize() > 0 && bb.getInstance(0) instanceof MoveOrderPull.MoveOrderPullInstance) {
/* 141 */           for (int i = 0; i < bb.instancesSize(); i++) {
/* 142 */             RoomInstance ii = bb.getInstance(i);
/* 143 */             if (ii instanceof MoveOrderPull.MoveOrderPullInstance) {
/* 144 */               MoveOrderPull.MoveOrderPullInstance pi = (MoveOrderPull.MoveOrderPullInstance)ii; byte b1; int j; MoveOrderPull[] arrayOfMoveOrderPull;
/* 145 */               for (j = (arrayOfMoveOrderPull = pi.moveOrdersPull()).length, b1 = 0; b1 < j; ) { MoveOrderPull p = arrayOfMoveOrderPull[b1];
/* 146 */                 if (p != null && p.source() == tar) {
/* 147 */                   ins.add(ii);
/* 148 */                   if (!ins.hasRoom()) {
/* 149 */                     return (LIST<RoomInstance>)ins;
/*     */                   }
/*     */                 } 
/*     */                 
/*     */                 b1++; }
/*     */             
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 161 */     return (LIST<RoomInstance>)ins; }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/*     */     activeSet(!all().isEmpty());
/*     */   }
/*     */   
/*     */   protected void clickA() {
/*     */     (VIEW.inters()).popup.show((RENDEROBJ)this.pop, (CLICKABLE)this, true);
/*     */   }
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/*     */     GBox b = (GBox)text;
/*     */     b.title(¤¤pullers);
/*     */     for (RoomInstance ins : all()) {
/*     */       b.add((SPRITE)ins.icon());
/*     */       b.text((CharSequence)ins.name());
/*     */       b.NL();
/*     */     } 
/*     */     super.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveOrderPullersUI.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */