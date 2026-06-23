/*     */ package view.world.generator;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.player.PTitles;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Butt
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   private final PTitles.PTitle title;
/*     */   
/*     */   Butt(PTitles.PTitle title) {
/*  93 */     super(title.name);
/*  94 */     icon(title.icon.scaled(2.0D));
/*  95 */     this.body.setDim(600.0D, (((PTitles.PTitle)(FACTIONS.player()).titles.all().get(0)).icon.height() * 2 + 8));
/*  96 */     this.title = title;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 101 */     activeSet(this.title.unlocked());
/* 102 */     selectedSet(this.title.selected());
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 107 */     GBox b = (GBox)text;
/* 108 */     if (!this.title.unlocked()) {
/* 109 */       b.error(Dic.¤¤Unavailable);
/*     */     } else {
/* 111 */       b.title(this.title.name);
/* 112 */       b.text(this.title.desc);
/* 113 */       b.sep();
/*     */       
/* 115 */       b.textLL(PTitles.¤¤racesUnlocked);
/* 116 */       b.NL();
/* 117 */       for (Race r : RACES.playable()) {
/* 118 */         if (this.title.race(r))
/* 119 */           b.add((SPRITE)(r.appearance()).iconBig); 
/*     */       } 
/* 121 */       b.NL();
/* 122 */       GText t = b.text();
/* 123 */       t.add(PTitles.¤¤racesUnlockedD);
/* 124 */       t.insert(0, 50.0D / RACES.playable().size(), 1);
/* 125 */       b.text((CharSequence)t);
/* 126 */       b.NL(4);
/*     */       
/* 128 */       b.textLL(PTitles.¤¤currentBoost);
/* 129 */       b.NL();
/* 130 */       this.title.boosters.hover(text, this.title.boosterValue(), null, -1);
/*     */       
/* 132 */       b.NL();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 141 */     super.render(r, ds, isActive, isSelected, isHovered);
/*     */ 
/*     */ 
/*     */     
/* 145 */     if (this.title.unlocked()) {
/* 146 */       int x1 = this.body.x1() + 120;
/* 147 */       int y1 = this.body.y2() - 25;
/* 148 */       for (Race ra : RACES.playable()) {
/* 149 */         if (this.title.race(ra)) {
/* 150 */           (ra.appearance()).icon.render(r, x1, y1);
/* 151 */           x1 += 26;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 159 */     if (this.title.selected()) {
/* 160 */       this.title.select(!this.title.selected());
/* 161 */     } else if (this.title.unlocked()) {
/*     */       
/* 163 */       if ((FACTIONS.player()).titles.selected() < 5)
/*     */       {
/*     */         
/* 166 */         this.title.select(!this.title.selected());
/*     */       }
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\StagePickTitles$Butt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */