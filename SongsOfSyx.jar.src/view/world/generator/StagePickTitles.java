/*     */ package view.world.generator;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.player.PTitles;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ class StagePickTitles extends GuiSection {
/*  28 */   static CharSequence ¤¤title = "¤Select Titles";
/*  29 */   static CharSequence ¤¤spent = "¤Pick 5 unlocked titles to boost your name.";
/*  30 */   static CharSequence ¤¤YouSure = "¤You may still pick some unlocked titles. Start anyway?";
/*     */   
/*     */   static {
/*  33 */     D.ts(StagePickTitles.class);
/*     */   }
/*     */ 
/*     */   
/*     */   StagePickTitles(final WorldViewGenerator stage) {
/*  38 */     addRelBody(4, DIR.S, (SPRITE)new GText((UI.FONT()).M, ¤¤spent));
/*     */     
/*  40 */     addRelBody(8, DIR.S, (RENDEROBJ)(new GStat((UI.FONT()).M)
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  44 */             GFORMAT.iofkInv(text, (FACTIONS.player()).titles.selected(), 5L);
/*     */           }
/*  47 */         }).r(DIR.N));
/*     */     
/*  49 */     ArrayList<RENDEROBJ> rows = new ArrayList((FACTIONS.player()).titles.all().size());
/*     */     
/*  51 */     for (PTitles.PTitle t : (FACTIONS.player()).titles.all()) {
/*  52 */       rows.add(new Butt(t));
/*     */     }
/*     */     
/*  55 */     addRelBody(8, DIR.S, (RENDEROBJ)(new GScrollRows((Iterable)rows, ((RENDEROBJ)rows.get(0)).body().height() * 6)).view());
/*     */     
/*  57 */     addRelBody(16, DIR.S, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤confirm)
/*     */         {
/*     */           protected void clickA() {
/*  60 */             ACTION no = new ACTION()
/*     */               {
/*     */                 public void exe() {}
/*     */               };
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*  68 */             ACTION next = new ACTION()
/*     */               {
/*     */                 public void exe()
/*     */                 {
/*  72 */                   stage.hasSelectedTitles = true;
/*  73 */                   stage.set();
/*     */                 }
/*     */               };
/*     */             
/*  77 */             if ((FACTIONS.player()).titles.selected() < 5 && (FACTIONS.player()).titles.unlocked() > (FACTIONS.player()).titles.selected()) {
/*  78 */               (VIEW.inters()).yesNo.activate(StagePickTitles.¤¤YouSure, next, no, true);
/*     */             } else {
/*  80 */               next.exe();
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/*  85 */     stage.dummy.add(this, ¤¤title);
/*     */   }
/*     */   
/*     */   private static final class Butt
/*     */     extends GButt.ButtPanel {
/*     */     private final PTitles.PTitle title;
/*     */     
/*     */     Butt(PTitles.PTitle title) {
/*  93 */       super(title.name);
/*  94 */       icon(title.icon.scaled(2.0D));
/*  95 */       this.body.setDim(600.0D, (((PTitles.PTitle)(FACTIONS.player()).titles.all().get(0)).icon.height() * 2 + 8));
/*  96 */       this.title = title;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void renAction() {
/* 101 */       activeSet(this.title.unlocked());
/* 102 */       selectedSet(this.title.selected());
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 107 */       GBox b = (GBox)text;
/* 108 */       if (!this.title.unlocked()) {
/* 109 */         b.error(Dic.¤¤Unavailable);
/*     */       } else {
/* 111 */         b.title(this.title.name);
/* 112 */         b.text(this.title.desc);
/* 113 */         b.sep();
/*     */         
/* 115 */         b.textLL(PTitles.¤¤racesUnlocked);
/* 116 */         b.NL();
/* 117 */         for (Race r : RACES.playable()) {
/* 118 */           if (this.title.race(r))
/* 119 */             b.add((SPRITE)(r.appearance()).iconBig); 
/*     */         } 
/* 121 */         b.NL();
/* 122 */         GText t = b.text();
/* 123 */         t.add(PTitles.¤¤racesUnlockedD);
/* 124 */         t.insert(0, 50.0D / RACES.playable().size(), 1);
/* 125 */         b.text((CharSequence)t);
/* 126 */         b.NL(4);
/*     */         
/* 128 */         b.textLL(PTitles.¤¤currentBoost);
/* 129 */         b.NL();
/* 130 */         this.title.boosters.hover(text, this.title.boosterValue(), null, -1);
/*     */         
/* 132 */         b.NL();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 141 */       super.render(r, ds, isActive, isSelected, isHovered);
/*     */ 
/*     */ 
/*     */       
/* 145 */       if (this.title.unlocked()) {
/* 146 */         int x1 = this.body.x1() + 120;
/* 147 */         int y1 = this.body.y2() - 25;
/* 148 */         for (Race ra : RACES.playable()) {
/* 149 */           if (this.title.race(ra)) {
/* 150 */             (ra.appearance()).icon.render(r, x1, y1);
/* 151 */             x1 += 26;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 159 */       if (this.title.selected()) {
/* 160 */         this.title.select(!this.title.selected());
/* 161 */       } else if (this.title.unlocked()) {
/*     */         
/* 163 */         if ((FACTIONS.player()).titles.selected() < 5)
/*     */         {
/*     */           
/* 166 */           this.title.select(!this.title.selected());
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\StagePickTitles.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */