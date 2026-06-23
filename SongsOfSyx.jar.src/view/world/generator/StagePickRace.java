/*     */ package view.world.generator;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTextScroller;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ class StagePickRace extends GuiSection {
/*  23 */   static CharSequence ¤¤title = "Select species";
/*  24 */   static CharSequence ¤¤desc = "All species have unique play styles, excel at different works, and have different likes and dislikes.";
/*     */   
/*  26 */   private static CharSequence ¤¤challenge = "Initial Challenge";
/*     */   static {
/*  28 */     D.ts(StagePickRace.class);
/*     */   }
/*     */ 
/*     */   
/*     */   StagePickRace(final WorldViewGenerator stages) {
/*  33 */     stages.reset();
/*     */     
/*  35 */     int i = 0;
/*  36 */     for (Race r : RACES.all()) {
/*  37 */       if (r.playable) {
/*  38 */         addGrid((RENDEROBJ)rButt(r), i++, 6, 4, 4);
/*     */       }
/*     */     } 
/*     */     
/*  42 */     addRelBody(16, DIR.N, (SPRITE)(new GText((UI.FONT()).M, ¤¤desc)).setMaxWidth(600));
/*     */ 
/*     */ 
/*     */     
/*  46 */     GETTER<CharSequence> cc = new GETTER<CharSequence>()
/*     */       {
/*     */         public CharSequence get()
/*     */         {
/*  50 */           return (FACTIONS.player().race()).info.desc_long;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  55 */     addRelBody(16, DIR.S, (RENDEROBJ)new GTextScroller((UI.FONT()).M, cc, 650, 150));
/*     */     
/*  57 */     addRelBody(16, DIR.S, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  61 */             text.add((FACTIONS.player().race()).info.initialChallenge);
/*     */           }
/*  64 */         }).increase().hv(¤¤challenge));
/*     */     
/*  66 */     addRelBody(16, DIR.S, (RENDEROBJ)new RENDEROBJ.RenderImp(650, 180)
/*     */         {
/*  68 */           private final GText t = new GText((UI.FONT()).M, 64);
/*     */ 
/*     */           
/*     */           public void render(SPRITE_RENDERER r, float ds) {
/*  72 */             Race rr = FACTIONS.player().race();
/*  73 */             int x = this.body.x1();
/*  74 */             int y = this.body.y1();
/*  75 */             this.t.setMaxWidth(280);
/*  76 */             this.t.setMultipleLines(true); byte b; int i; String[] arrayOfString;
/*  77 */             for (i = (arrayOfString = rr.info.pros).length, b = 0; b < i; ) { String s = arrayOfString[b];
/*  78 */               this.t.clear().add('+').s().add(s).adjustWidth();
/*  79 */               this.t.normalify2();
/*  80 */               this.t.render(r, x + 16, y);
/*  81 */               y += this.t.height(); b++; }
/*     */             
/*  83 */             y = this.body.y1();
/*  84 */             for (i = (arrayOfString = rr.info.cons).length, b = 0; b < i; ) { String s = arrayOfString[b];
/*  85 */               this.t.clear().add('-').s().add(s).adjustWidth();
/*  86 */               this.t.errorify();
/*  87 */               this.t.render(r, x + 325, y);
/*  88 */               y += this.t.height();
/*     */ 
/*     */               
/*     */               b++; }
/*     */           
/*     */           }
/*     */         });
/*     */     
/*  96 */     int p = 650 - body().width();
/*  97 */     if (p > 0) {
/*  98 */       pad(p / 2, 0);
/*     */     }
/* 100 */     addRelBody(16, DIR.S, (RENDEROBJ)(new GButt.ButtPanel(Dic.¤¤confirm)
/*     */         {
/*     */           protected void clickA() {
/* 103 */             stages.hasSeletedRace = true;
/* 104 */             stages.set();
/*     */           }
/* 107 */         }).hoverInfoSet(Dic.¤¤confirm));
/*     */     
/* 109 */     pad(0, 8);
/*     */     
/* 111 */     stages.dummy.add(this, ¤¤title);
/*     */   }
/*     */ 
/*     */   
/*     */   private CLICKABLE rButt(final Race r) {
/* 116 */     GButt.ButtPanel b = new GButt.ButtPanel((r.appearance()).iconBig.huge)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 120 */           FACTIONS.player().setRace(r);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 125 */           selectedSet((FACTIONS.player().race() == r));
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 130 */           text.title(r.info.name);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 136 */     b.pad(10, 10);
/* 137 */     return (CLICKABLE)b;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\StagePickRace.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */