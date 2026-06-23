/*     */ package view.sett.ui.noble;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BoostSpec;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import view.interrupter.ISidePanel;
/*     */ 
/*     */ public final class UINobles extends ISidePanel {
/*  24 */   private static CharSequence ¤¤expla = "To assign another noble you must click a subject and elevate them from there.";
/*     */   static {
/*  26 */     D.ts(UINobles.class);
/*     */   }
/*  28 */   final NobleAssigns assigns = new NobleAssigns();
/*     */   
/*     */   public UINobles() {
/*  31 */     titleSet((HCLASSES.NOBLE()).names);
/*     */     
/*  33 */     this.section.addRelBody(0, DIR.S, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  37 */             GFORMAT.iofkInv(text, GAME.NOBLE().active().size(), (int)(GAME.NOBLE()).MAX.get((BOOSTABLE_O)HCLASS_RACE.clP()));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  42 */             b.text(UINobles.¤¤expla);
/*  43 */             b.NL();
/*  44 */             (GAME.NOBLE()).MAX.hoverDetailed((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP(), null, true);
/*     */           }
/*  47 */         }).hv((HCLASSES.NOBLE()).names));
/*     */     
/*  49 */     this.section.addRelBody(80, DIR.E, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  53 */             GFORMAT.iofkInv(text, GAME.NOBLE().ranksAllocated(), (int)(GAME.NOBLE()).MAX_RANKS.get((BOOSTABLE_O)HCLASS_RACE.clP()));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  58 */             b.text((GAME.NOBLE()).MAX_RANKS.desc);
/*  59 */             b.NL();
/*  60 */             (GAME.NOBLE()).MAX_RANKS.hoverDetailed((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP(), null, true);
/*     */           }
/*  63 */         }).hv((GAME.NOBLE()).MAX_RANKS.name));
/*     */     
/*  65 */     this.section.addRelBody(80, DIR.E, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).m.plus)
/*     */         {
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/*  71 */             GBox b = (GBox)text;
/*     */ 
/*     */             
/*  74 */             for (int si = 0; si < (GAME.NOBLE()).boosters.all().size(); si++) {
/*  75 */               BoostSpec s = (BoostSpec)(GAME.NOBLE()).boosters.all().get(si);
/*  76 */               double v = s.get((BOOSTABLE_O)HCLASS_RACE.clP());
/*  77 */               if (v > 0.0D) {
/*  78 */                 (GAME.NOBLE()).boosters.hover(b, s, v, 0);
/*  79 */                 b.tab(8);
/*     */                 
/*  81 */                 b.NL();
/*     */               } 
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  90 */     GTableBuilder bu = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  94 */           return GAME.NOBLE().active().size();
/*     */         }
/*     */       };
/*     */     
/*  98 */     bu.column(null, NobleRow.width, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(GETTER<Integer> ier)
/*     */           {
/* 102 */             return (RENDEROBJ)new NobleRow(ier);
/*     */           }
/*     */         });
/*     */     
/* 106 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)bu.createHeight(HEIGHT - 32 - this.section.body().height(), false));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\noble\UINobles.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */