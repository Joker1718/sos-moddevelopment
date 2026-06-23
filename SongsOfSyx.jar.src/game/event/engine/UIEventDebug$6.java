/*     */ package game.event.engine;
/*     */ 
/*     */ import game.faction.Faction;
/*     */ import game.faction.royalty.Royalty;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
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
/*     */ 
/*     */ class null
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   null(SPRITE $anonymous0) {
/* 126 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 132 */     GBox b = (GBox)text;
/*     */     
/* 134 */     UIEventDebug.this.hover(b, a);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 140 */     en.set(a, false, false, true, true);
/* 141 */     GuiSection pop = new GuiSection();
/* 142 */     EContext c = en.context();
/* 143 */     GText t = new GText((UI.FONT()).S, "indu: ");
/* 144 */     t.add(c.indu.am).s();
/* 145 */     int am = 0; int i;
/* 146 */     for (i = 0; i < (en.context()).indu.max(); i++) {
/* 147 */       Induvidual tt = c.indu.get(i);
/* 148 */       if (tt != null && c.indu.eventGet(tt) && 
/* 149 */         am++ < 4) {
/* 150 */         t.add(STATS.APPEARANCE().name(tt)).s();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 155 */     t.s().add(am);
/* 156 */     t.adjustWidth();
/* 157 */     pop.addDownC(8, (SPRITE)t);
/*     */     
/* 159 */     t = new GText((UI.FONT()).S, "regs: ");
/* 160 */     t.add(c.regs.am).s();
/* 161 */     am = 0;
/* 162 */     for (i = 0; i < c.regs.max(); i++) {
/* 163 */       Region tt = c.regs.get(i);
/* 164 */       if (tt != null && c.regs.eventGet(tt) && 
/* 165 */         am++ < 4) {
/* 166 */         t.add((CharSequence)tt.info.name()).s();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 171 */     t.s().add(am);
/* 172 */     t.adjustWidth();
/* 173 */     pop.addDownC(8, (SPRITE)t);
/*     */     
/* 175 */     t = new GText((UI.FONT()).S, "roys: ");
/* 176 */     t.add(c.royalty.am).s();
/* 177 */     am = 0;
/* 178 */     for (i = 0; i < c.royalty.max(); i++) {
/* 179 */       Royalty tt = c.royalty.get(i);
/* 180 */       if (tt != null && c.royalty.eventGet(tt) && 
/* 181 */         am++ < 4) {
/* 182 */         t.add(String.valueOf(tt.name()) + " (" + String.valueOf(tt.name()) + ") ");
/*     */       }
/*     */     } 
/*     */     
/* 186 */     t.s().add(am);
/* 187 */     t.adjustWidth();
/* 188 */     pop.addDownC(8, (SPRITE)t);
/*     */     
/* 190 */     t = new GText((UI.FONT()).S, "fact: ");
/* 191 */     t.add(c.faction.am).s();
/* 192 */     am = 0;
/* 193 */     for (i = 0; i < c.faction.max(); i++) {
/* 194 */       Faction tt = c.faction.get(i);
/* 195 */       if (tt != null && c.faction.eventGet(tt) && 
/* 196 */         am++ < 4) {
/* 197 */         t.add((CharSequence)tt.name).s();
/*     */       }
/*     */     } 
/*     */     
/* 201 */     t.s().add(am);
/* 202 */     t.adjustWidth();
/* 203 */     pop.addDownC(8, (SPRITE)t);
/*     */     
/* 205 */     (VIEW.inters()).popup2.show((RENDEROBJ)pop, (CLICKABLE)this);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\engine\UIEventDebug$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */