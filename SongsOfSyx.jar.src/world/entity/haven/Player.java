/*     */ package world.entity.haven;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ import view.ui.message.MessageSection;
/*     */ import view.ui.message.MessageText;
/*     */ import world.WORLD;
/*     */ import world.entity.WEntity;
/*     */ 
/*     */ class Player
/*     */   implements SAVABLE
/*     */ {
/*  29 */   private static CharSequence ¤¤titleNew = "Haven controlled";
/*  30 */   private static CharSequence ¤¤bodyNew = "We now have under our control a haven. Havens are bastions containing powerful races that you can sway to your cause if you fulfill their requirements.";
/*     */   
/*  32 */   private static CharSequence ¤¤titleMore = "More {0} join you";
/*  33 */   private static CharSequence ¤¤bodyMore = "Since your worth has increased in the eyes of your {0}. More are willing to join your cause. Make sure you accept them as immigrants.";
/*     */   
/*  35 */   private static CharSequence ¤¤titleLess = "{0} are leaving!";
/*  36 */   private static CharSequence ¤¤bodyLess = "Since you've failed to uphold the standards of your {0} havens, many have now stopped supporting you, and all its members will start to return home.";
/*     */   
/*     */   static {
/*  39 */     D.ts(Player.class);
/*     */   }
/*     */   
/*     */   private double[] oldValue;
/*     */   private boolean hasAny;
/*     */   private double upT;
/*     */   
/*     */   Player(WHavens havens) {
/*  47 */     this.oldValue = new double[havens.types.size()];
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  52 */     file.dsE(this.oldValue);
/*  53 */     file.d(this.upT);
/*  54 */     file.bool(this.hasAny);
/*     */   }
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  58 */     file.dsE(this.oldValue);
/*  59 */     this.upT = file.d();
/*  60 */     this.hasAny = file.bool();
/*     */   }
/*     */   
/*     */   public void clear() {
/*  64 */     Arrays.fill(this.oldValue, 0.0D);
/*  65 */     this.upT = 0.0D;
/*  66 */     this.hasAny = false;
/*     */   }
/*     */ 
/*     */   
/*     */   void update(double ds) {
/*  71 */     this.upT += ds * 0.1D;
/*  72 */     if (this.upT < 10.0D)
/*     */       return; 
/*  74 */     this.upT -= 10.0D;
/*     */     
/*  76 */     for (WHavenType t : (WORLD.ENTITIES()).havens.types) {
/*  77 */       if (update(t)) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean update(WHavenType t) {
/*  85 */     if ((WORLD.ENTITIES()).havens.camps((Faction)FACTIONS.player(), t) == 0) {
/*  86 */       return false;
/*     */     }
/*  88 */     if (!this.hasAny && (WORLD.ENTITIES()).havens.camps((Faction)FACTIONS.player(), t) > 0) {
/*  89 */       this.hasAny = true;
/*  90 */       (new MessOwn()).send();
/*  91 */       return true;
/*     */     } 
/*     */     
/*  94 */     double old = this.oldValue[t.index()];
/*     */     
/*  96 */     double nn = t.amount();
/*     */     
/*  98 */     if (nn <= 0.0D && old > 0.0D) {
/*  99 */       if (t.reqsFrom.progress(FACTIONS.player()) < 0.75D) {
/* 100 */         this.oldValue[t.index()] = 0.0D;
/* 101 */         (new MessageText((CharSequence)(new Str(¤¤titleLess)).insert(0, t.race.info.names), (CharSequence)(new Str(¤¤bodyLess)).insert(0, t.race.info.names))).send();
/* 102 */         return true;
/*     */       } 
/* 104 */       return false;
/*     */     } 
/*     */     
/* 107 */     int iold = (int)Math.round(old * 5.0D);
/* 108 */     int inew = (int)Math.round(nn * 5.0D);
/*     */     
/* 110 */     if (inew > iold) {
/* 111 */       SETT.ENTRY().immi().setHigher(t.race, (int)(WORLD.camps().max((Faction)FACTIONS.player(), t) * nn));
/* 112 */       if (iold == 0) {
/* 113 */         (new MessChange(t, (CharSequence)(new Str(¤¤titleMore)).insert(0, t.race.info.names), t.sJoin)).send();
/*     */       } else {
/* 115 */         (new MessChange(t, (CharSequence)(new Str(¤¤titleMore)).insert(0, t.race.info.names), (CharSequence)(new Str(¤¤bodyMore)).insert(0, t.race.info.names))).send();
/* 116 */       }  this.oldValue[t.index()] = nn;
/* 117 */       return true;
/* 118 */     }  if (inew < iold - 1) {
/* 119 */       (new MessChange(t, (CharSequence)(new Str(¤¤titleLess)).insert(0, t.race.info.names), t.sLeave)).send();
/* 120 */       this.oldValue[t.index()] = nn;
/* 121 */       return true;
/*     */     } 
/*     */     
/* 124 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   double get(Faction f, WHavenType t) {
/* 129 */     if (f == FACTIONS.player())
/* 130 */       return this.oldValue[t.index()]; 
/* 131 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   private static class MessOwn
/*     */     extends MessageSection
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     final int tx;
/*     */     final int ty;
/*     */     
/*     */     public MessOwn() {
/* 144 */       super(Player.¤¤titleNew);
/* 145 */       WHaven f = first();
/* 146 */       this.tx = f.ctx();
/* 147 */       this.ty = f.cty();
/*     */     }
/*     */     
/*     */     private WHaven first() {
/* 151 */       for (WEntity e : WORLD.ENTITIES().allSlow()) {
/* 152 */         if (e.faction() == FACTIONS.player() && e instanceof WHaven) {
/* 153 */           return (WHaven)e;
/*     */         }
/*     */       } 
/* 156 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void make(GuiSection section) {
/* 161 */       paragraph(Player.¤¤bodyNew);
/*     */       
/* 163 */       section.addRelBody(16, DIR.S, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).m.crossair)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 167 */               VIEW.world().activate();
/* 168 */               (VIEW.world()).window.setZoomout(0);
/* 169 */               (VIEW.world()).window.centererTile.set(Player.MessOwn.this.tx, Player.MessOwn.this.ty);
/*     */             }
/*     */           });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class MessChange
/*     */     extends MessageSection
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */     
/*     */     private final int ti;
/*     */     
/*     */     private final String desc;
/*     */ 
/*     */     
/*     */     public MessChange(WHavenType t, CharSequence title, CharSequence desc) {
/* 189 */       super(title);
/* 190 */       this.ti = t.index();
/* 191 */       this.desc = String.valueOf(desc);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void make(GuiSection section) {
/* 197 */       paragraph(this.desc);
/* 198 */       section.addRelBody(16, DIR.N, (SPRITE)new SPRITE.Imp(64)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */             {
/* 202 */               (((WHavenType)(WORLD.camps()).types.getC(Player.MessChange.this.ti)).race.appearance()).iconBig.render(r, X1, X2, Y1, Y2);
/*     */             }
/*     */           });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\haven\Player.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */