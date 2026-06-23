/*     */ package view.ui.diplomacy;
/*     */ 
/*     */ import game.faction.diplomacy.deal.DealBool;
/*     */ import game.faction.diplomacy.deal.DealParty;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TRADABLE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
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
/*     */ class Row
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   private final GETTER<Integer> ier;
/* 125 */   private final GText header = (new GText((UI.FONT()).H2, 24)).lablify();
/* 126 */   private final GText name = (new GText((UI.FONT()).H2, 24)).normalify();
/*     */   
/*     */   Row(GETTER<Integer> ier) {
/* 129 */     super(340, 32);
/* 130 */     this.ier = ier;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 136 */     Object o = UIDealList.this.all[((Integer)this.ier.get()).intValue()];
/* 137 */     DealParty p = (((Integer)this.ier.get()).intValue() >= UIDealList.this.npcStart) ? UIDealList.this.deal.player : UIDealList.this.deal.npc;
/*     */     
/* 139 */     if (o == null) {
/* 140 */       this.header.clear();
/* 141 */       if (p == UIDealList.this.deal.player) {
/* 142 */         this.header.add(UIDealList.¤¤FactionGets);
/* 143 */         this.header.insert(0, (CharSequence)(UIDealList.this.deal.npc.npc()).name);
/* 144 */         this.header.adjustWidth();
/*     */       } else {
/*     */         
/* 147 */         this.header.set(UIDealList.¤¤YouGet);
/*     */       } 
/*     */       
/* 150 */       this.header.renderCXY2(r, this.body.cX(), this.body.y2() - 4);
/*     */     } else {
/* 152 */       GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 153 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/* 154 */       if (o instanceof DealBool) {
/* 155 */         DealBool b = (DealBool)o;
/* 156 */         render(r, b.icon, b.info.name);
/* 157 */       } else if (o instanceof util.data.INT) {
/* 158 */         this.name.clear().add(p.credits.get());
/* 159 */         render(r, (SPRITE)(UI.icons()).s.money);
/* 160 */       } else if (o instanceof Region) {
/* 161 */         Region rr = (Region)o;
/* 162 */         if (rr.faction() != null)
/* 163 */           render(r, (rr.faction().banner()).MEDIUM, (CharSequence)rr.info.name()); 
/* 164 */       } else if (o instanceof TRADABLE) {
/* 165 */         TRADABLE rr = (TRADABLE)o;
/* 166 */         this.name.clear().add(p.resources.get(rr));
/* 167 */         render(r, rr.icon());
/*     */       } else {
/*     */         
/* 170 */         throw new RuntimeException(String.valueOf(o));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void render(SPRITE_RENDERER r, SPRITE icon) {
/* 179 */     icon.renderCY(r, body().x1() + 8, body().cY());
/* 180 */     this.name.renderCY(r, body().x1() + 40, body().cY());
/*     */   }
/*     */   
/*     */   private void render(SPRITE_RENDERER r, SPRITE icon, CharSequence name) {
/* 184 */     this.name.clear().add(name);
/* 185 */     render(r, icon);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 191 */     Object o = UIDealList.this.all[((Integer)this.ier.get()).intValue()];
/* 192 */     DealParty p = (((Integer)this.ier.get()).intValue() >= UIDealList.this.npcStart) ? UIDealList.this.deal.player : UIDealList.this.deal.npc;
/*     */     
/* 194 */     if (o == null) {
/*     */       return;
/*     */     }
/* 197 */     if (o instanceof DealBool) {
/* 198 */       DealBool b = (DealBool)o;
/* 199 */       b.set(false);
/* 200 */     } else if (o instanceof util.data.INT) {
/* 201 */       p.credits.set(0);
/* 202 */     } else if (o instanceof Region) {
/* 203 */       p.regs.select((Region)o, false);
/* 204 */     } else if (o instanceof TRADABLE) {
/* 205 */       p.resources.set(o, 0);
/*     */     } 
/*     */ 
/*     */     
/* 209 */     super.clickA();
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 214 */     Object o = UIDealList.this.all[((Integer)this.ier.get()).intValue()];
/* 215 */     DealParty p = (((Integer)this.ier.get()).intValue() >= UIDealList.this.npcStart) ? UIDealList.this.deal.player : UIDealList.this.deal.npc;
/* 216 */     if (o == null)
/*     */       return; 
/* 218 */     GBox b = (GBox)text;
/* 219 */     int value = 0;
/* 220 */     if (o instanceof DealBool) {
/* 221 */       DealBool vv = (DealBool)o;
/* 222 */       b.title(vv.info.name);
/* 223 */       b.text(vv.info.desc);
/* 224 */       value = (int)vv.value();
/* 225 */     } else if (o instanceof util.data.INT) {
/* 226 */       value = p.credits.get();
/* 227 */     } else if (o instanceof Region) {
/* 228 */       Region reg = (Region)o;
/* 229 */       (VIEW.world()).UI.regions.hover(reg, (GUI_BOX)b);
/* 230 */       value = p.regs.value(reg);
/* 231 */     } else if (o instanceof TRADABLE) {
/* 232 */       TRADABLE res = (TRADABLE)o;
/* 233 */       b.title(res.names);
/* 234 */       value = p.valueResource(res, p.resources.get(res));
/*     */     } 
/* 236 */     b.NL();
/* 237 */     b.add((SPRITE)(UI.icons()).s.money);
/* 238 */     b.add((SPRITE)GFORMAT.i(b.text(), value));
/* 239 */     super.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\diplomacy\UIDealList$Row.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */