/*     */ package view.ui.diplomacy;
/*     */ 
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.deal.Deal;
/*     */ import game.faction.diplomacy.deal.DealParty;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.common.UIPickerRegion;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Regionlist
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   private final GuiSection pop;
/*     */   private final DealParty p;
/*     */   
/*     */   Regionlist(Deal deal, final DealParty p, DealParty ff) {
/* 129 */     super(Dic.¤¤Regions);
/* 130 */     this.p = p;
/* 131 */     icon((SPRITE)(UI.icons()).s.world);
/* 132 */     body().setDim(UIDealConfig.BW, UIDealConfig.BH);
/* 133 */     GETTER<Faction> gg = new GETTER<Faction>()
/*     */       {
/*     */         public Faction get()
/*     */         {
/* 137 */           return p.f();
/*     */         }
/*     */       };
/*     */     
/* 141 */     this.pop = (GuiSection)new UIPickerRegion(gg, 400)
/*     */       {
/*     */         protected void toggle(Region reg)
/*     */         {
/* 145 */           p.regs.select(reg, !p.regs.selected(reg));
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean active(Region reg) {
/* 150 */           return p.regs.selecteCan(reg);
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean selected(Region reg) {
/* 155 */           return p.regs.selected(reg);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void hoverInfo(GBox b, Region reg) {
/* 161 */           b.add((SPRITE)(UI.icons()).s.money);
/* 162 */           b.add((SPRITE)GFORMAT.i(b.text(), p.regs.value(reg)));
/* 163 */           b.NL(8);
/*     */           
/* 165 */           super.hoverInfo(b, reg);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 174 */     (VIEW.inters()).popup.show((RENDEROBJ)this.pop, (CLICKABLE)this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 179 */     activeSet((this.p.f().realm().regions() > 1));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\diplomacy\UIDealConfig$Regionlist.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */