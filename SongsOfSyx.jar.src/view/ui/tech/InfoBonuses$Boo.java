/*     */ package view.ui.tech;
/*     */ 
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.Boostable;
/*     */ import game.faction.FACTIONS;
/*     */ import init.sprite.UI.UI;
/*     */ import init.tech.TECH;
/*     */ import init.tech.TECHS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Boo
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   private final Boostable bo;
/* 127 */   private ArrayListGrower<TECH> techs = new ArrayListGrower();
/*     */   
/*     */   public Boo(Boostable bo) {
/* 130 */     super(300, 18);
/* 131 */     this.bo = bo;
/* 132 */     for (TECH t : TECHS.ALL()) {
/* 133 */       for (BoostSpec b : t.boosters.all()) {
/* 134 */         if (b.boostable == bo) {
/* 135 */           this.techs.add(t);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 143 */     if (this.techs.size() == 0) {
/* 144 */       OPACITY.O50.bind();
/* 145 */     } else if (!isHovered) {
/* 146 */       OPACITY.O85.bind();
/*     */     } 
/* 148 */     this.bo.icon.render(r, body().x1(), body().y1());
/*     */     
/* 150 */     if (this.techs.size() > 0)
/* 151 */       (GCOLOR.T()).H1.bind(); 
/* 152 */     (UI.FONT()).S.render(r, this.bo.name, body().x1() + 20, body().y1(), 0, (this.bo.name.length() > 15) ? 15 : this.bo.name.length(), 1.0D);
/* 153 */     COLOR.unbind();
/* 154 */     OPACITY.unbind();
/* 155 */     InfoBonuses.this.t.clear();
/* 156 */     double add = 0.0D;
/* 157 */     double mul = 1.0D;
/* 158 */     for (TECH t : this.techs) {
/* 159 */       for (BoostSpec b : t.boosters.all()) {
/* 160 */         if (b.boostable == this.bo) {
/* 161 */           if (b.booster.isMul) {
/* 162 */             mul *= (FACTIONS.player()).tech.level(t) * (b.booster.to() - 1.0D) + 1.0D; continue;
/*     */           } 
/* 164 */           add += (FACTIONS.player()).tech.level(t) * b.booster.to();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 170 */     GFORMAT.percInc(InfoBonuses.this.t, (add + 1.0D) * mul - 1.0D);
/* 171 */     InfoBonuses.this.t.render(r, this.body.x1() + 220, this.body.y1());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 176 */     if (this.techs.size() == 0)
/*     */       return; 
/* 178 */     InfoBonuses.this.tree.filter.set(this.bo.name);
/* 179 */     super.clickA();
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 184 */     text.title(this.bo.name);
/* 185 */     text.text(this.bo.desc);
/* 186 */     text.NL(8);
/*     */     
/* 188 */     GBox box = (GBox)text;
/* 189 */     for (TECH t : this.techs) {
/* 190 */       for (BoostSpec b : t.boosters.all()) {
/* 191 */         if (b.boostable == this.bo) {
/* 192 */           if (b.booster.isMul) {
/* 193 */             b.booster.hover((GUI_BOX)box, (FACTIONS.player()).tech.level(t) * (b.booster.to() - 1.0D) + 1.0D); continue;
/*     */           } 
/* 195 */           b.booster.hover((GUI_BOX)box, (FACTIONS.player()).tech.level(t) * b.booster.to());
/*     */         } 
/*     */       } 
/*     */       
/* 199 */       box.NL();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tech\InfoBonuses$Boo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */