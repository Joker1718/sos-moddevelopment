/*     */ package view.ui.profile;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.FactionProfileFlusher;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GInput;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class UIProfile extends IFullView {
/*  18 */   private static CharSequence ¤¤Name = "¤Player";
/*  19 */   private static CharSequence ¤¤Save = "¤Save as Default";
/*  20 */   private static CharSequence ¤¤Load = "¤Load Default";
/*  21 */   private static CharSequence ¤¤FName = "¤Faction Name";
/*  22 */   private static CharSequence ¤¤RName = "¤Ruler Name";
/*     */   
/*     */   static {
/*  25 */     D.ts(UIProfile.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public UIProfile(boolean crashThing) {
/*  30 */     super(¤¤Name, (FACTIONS.player().banner()).BIG);
/*     */     
/*  32 */     this.section.body().setWidth(WIDTH).setHeight(1.0D);
/*     */     
/*  34 */     this.section.addRelBody(16, DIR.S, (RENDEROBJ)section(crashThing));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GuiSection section(boolean crashThing) {
/*  40 */     GuiSection s = new GuiSection();
/*  41 */     s.add((RENDEROBJ)new UIFactionBanner((Faction)FACTIONS.player()));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  46 */     s.addRelBody(16, DIR.N, (RENDEROBJ)info(crashThing));
/*  47 */     s.addRelBody(8, DIR.S, (RENDEROBJ)loadButts());
/*  48 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   private static GuiSection loadButts() {
/*  53 */     GuiSection s = new GuiSection();
/*     */     
/*  55 */     s.add((RENDEROBJ)new GButt.ButtPanel(¤¤Save)
/*     */         {
/*     */           protected void clickA() {
/*  58 */             FactionProfileFlusher.flush(FACTIONS.player());
/*     */           }
/*     */         });
/*     */     
/*  62 */     s.addRightC(32, (RENDEROBJ)new GButt.ButtPanel(¤¤Load)
/*     */         {
/*     */           protected void renAction()
/*     */           {
/*  66 */             activeSet(FactionProfileFlusher.canLoad(FACTIONS.player()));
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/*  71 */             FactionProfileFlusher.load(FACTIONS.player());
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  76 */     return s;
/*     */   }
/*     */   
/*     */   private static GuiSection info(boolean crashThing) {
/*  80 */     GuiSection s = new GuiSection();
/*  81 */     StringInputSprite t = new StringInputSprite(24, (UI.FONT()).H2)
/*     */       {
/*     */         public Str text()
/*     */         {
/*  85 */           return (FACTIONS.player()).name;
/*     */         }
/*     */ 
/*     */         
/*     */         protected void change() {
/*  90 */           if (FACTIONS.player().capitolRegion() != null)
/*  91 */             (FACTIONS.player().capitolRegion()).info.name().clear().add((CharSequence)text()); 
/*  92 */           super.change();
/*     */         }
/*     */       };
/*     */     
/*  96 */     GInput in = new GInput(t);
/*  97 */     s.add((RENDEROBJ)new GHeader(¤¤FName));
/*  98 */     s.addRightCAbs(210, (RENDEROBJ)in);
/*     */     
/* 100 */     t = new StringInputSprite(24, (UI.FONT()).H2)
/*     */       {
/*     */         
/*     */         public Str text()
/*     */         {
/* 105 */           return (FACTIONS.player()).rulerName;
/*     */         }
/*     */       };
/* 108 */     in = new GInput(t);
/* 109 */     s.add((RENDEROBJ)new GHeader(¤¤RName), 0, s.getLastY2() + 12);
/* 110 */     s.addRightCAbs(210, (RENDEROBJ)in);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 123 */     if (crashThing) {
/* 124 */       s.addRelBody(16, DIR.E, (RENDEROBJ)(new ColorPop()).butt());
/*     */     }
/* 126 */     return s;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\profile\UIProfile.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */