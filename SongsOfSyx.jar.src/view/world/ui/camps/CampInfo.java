/*     */ package view.world.ui.camps;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.WORLD;
/*     */ import world.entity.haven.WHaven;
/*     */ import world.entity.haven.WHavenType;
/*     */ 
/*     */ final class CampInfo extends GuiSection {
/*  28 */   private static CharSequence ¤¤notFull = "¤Fulfill this species requirements to unlock the help of the havens that are within your realm."; private final WHavenType type;
/*  29 */   private static CharSequence ¤¤full = "¤The requirements have been met and the havens on your lands are at your service.";
/*  30 */   private static CharSequence ¤¤Replenish = "Replenish";
/*     */   
/*  32 */   private static CharSequence ¤¤unlocked = "This haven is on your lands and at your service.";
/*  33 */   private static CharSequence ¤¤onLands = "This haven is on your lands, but the requirements are not met for them to join your cause.";
/*  34 */   private static CharSequence ¤¤distant = "This haven is not on your lands and can not serve you.";
/*     */   
/*  36 */   private static CharSequence ¤¤max = "Haven Max Population";
/*  37 */   private static CharSequence ¤¤unlockedAm = "Unlocked Population";
/*     */   
/*     */   static {
/*  40 */     D.ts(CampInfo.class);
/*     */   }
/*     */   
/*     */   public CampInfo(final WHavenType type) {
/*  44 */     this.type = type;
/*  45 */     add((SPRITE)(type.race.appearance()).iconBig, 0, 0);
/*  46 */     add((RENDEROBJ)new GHeader(type.race.info.names, (UI.FONT()).S), getLastX2() + 8, 0);
/*     */     
/*  48 */     add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  52 */             GFORMAT.iofkInv(text, WORLD.camps().current((Faction)FACTIONS.player(), type), WORLD.camps().max((Faction)FACTIONS.player(), type));
/*     */           }
/*  54 */         }).hh((SPRITE)(SPRITES.icons()).s.human), getLastX1(), getLastY2());
/*     */     
/*  56 */     addRightC(64, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  60 */             GFORMAT.f0(text, WORLD.camps().replenishPerDay((Faction)FACTIONS.player(), type));
/*     */           }
/*  62 */         }).hh((SPRITE)(SPRITES.icons()).s.clock));
/*     */     
/*  64 */     addRightC(64, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  68 */             GFORMAT.i(text, WORLD.camps().camps((Faction)FACTIONS.player(), type));
/*     */           }
/*  70 */         }).hh((SPRITE)(SPRITES.icons()).s.house));
/*     */     
/*  72 */     body().incrW(48.0D);
/*     */     
/*  74 */     addRelBody(4, DIR.S, (SPRITE)new SPRITE.Imp(body().width(), 12)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/*  78 */             double d = type.reqsFrom.progress(null);
/*  79 */             if (d >= 1.0D) {
/*  80 */               GMeter.render(r, GMeter.C_BLUE, type.amount(), X1, X2, Y1, Y2);
/*     */             } else {
/*  82 */               GMeter.render(r, GMeter.C_ORANGE, d, X1, X2, Y1, Y2);
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/*  87 */     pad(16, 8);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/*  93 */     GBox b = (GBox)text;
/*  94 */     b.title(this.type.race.info.names);
/*  95 */     b.text(this.type.race.info.desc);
/*     */     
/*  97 */     b.NL(4);
/*  98 */     if (this.type.reqsFrom.passes(null)) {
/*  99 */       b.add((SPRITE)b.text().normalify2().add(¤¤full));
/*     */     } else {
/* 101 */       b.add((SPRITE)b.text().warnify().add(¤¤notFull));
/*     */     } 
/* 103 */     b.NL(8);
/* 104 */     b.textLL(Dic.¤¤havens);
/* 105 */     b.tab(6);
/* 106 */     b.add((SPRITE)GFORMAT.i(b.text(), WORLD.camps().camps((Faction)FACTIONS.player(), this.type)));
/*     */     
/* 108 */     b.NL();
/* 109 */     b.textLL(¤¤max);
/* 110 */     b.tab(6);
/* 111 */     b.add((SPRITE)GFORMAT.i(b.text(), WORLD.camps().max((Faction)FACTIONS.player(), this.type)));
/*     */     
/* 113 */     b.NL();
/* 114 */     b.textLL(¤¤unlockedAm);
/* 115 */     b.tab(6);
/* 116 */     b.add((SPRITE)GFORMAT.i(b.text(), WORLD.camps().current((Faction)FACTIONS.player(), this.type)));
/*     */     
/* 118 */     b.NL();
/* 119 */     b.textLL(¤¤Replenish);
/* 120 */     b.tab(6);
/* 121 */     b.add((SPRITE)GFORMAT.f0(b.text(), WORLD.camps().replenishPerDay((Faction)FACTIONS.player(), this.type)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 127 */     b.NL(8);
/* 128 */     this.type.reqsFrom.hover(text, null);
/* 129 */     b.NL(8);
/*     */ 
/*     */     
/* 132 */     b.sep();
/* 133 */     b.textLL(Dic.¤¤Progress);
/* 134 */     b.NL();
/* 135 */     this.type.hoverProgress((GUI_BOX)b);
/*     */     
/* 137 */     super.hoverInfoGet(text);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 142 */     GButt.ButtPanel.renderBG(r, true, false, hoveredIs(), (RECTANGLE)body());
/* 143 */     super.render(r, ds);
/* 144 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/*     */   }
/*     */   
/*     */   static void hover(GUI_BOX box, WHaven ins) {
/* 148 */     GBox b = (GBox)box;
/* 149 */     b.title((CharSequence)ins.name);
/* 150 */     b.NL();
/* 151 */     b.textL((ins.type()).race.info.names);
/* 152 */     b.tab(5);
/* 153 */     b.add((SPRITE)GFORMAT.i(b.text(), ins.pop()));
/* 154 */     b.NL(8);
/*     */     
/* 156 */     if (ins.faction() != FACTIONS.player()) {
/* 157 */       b.add((SPRITE)b.text().warnify().add(¤¤distant));
/* 158 */     } else if ((ins.type()).reqsFrom.passes(null)) {
/* 159 */       b.add((SPRITE)b.text().normalify2().add(¤¤unlocked));
/*     */     } else {
/* 161 */       b.add((SPRITE)b.text().warnify().add(¤¤onLands));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\camps\CampInfo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */