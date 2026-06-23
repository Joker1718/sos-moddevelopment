/*     */ package game.faction.player.emmi;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoosterValue;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import game.faction.royalty.NPCCourt;
/*     */ import game.faction.royalty.Royalty;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.updating.IUpdater;
/*     */ import view.interrupter.IDebugPanel;
/*     */ import view.main.VIEW;
/*     */ import view.ui.message.MessageText;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ public class Emissaries {
/*  42 */   public static CharSequence ¤¤name = "Emissary Points";
/*  43 */   public static CharSequence ¤¤desc = "Emissaries are used to influence foreign courts, or to increase support in regions outside of your realm. Emissaries are trained in an embassy, and can be assigned in the faction panel or the region panel.";
/*  44 */   private static CharSequence ¤¤low = "Emissary points Low";
/*  45 */   private static CharSequence ¤¤lowD = "We do no longer employ as many emissaries as are needed. As a result, all our diplomatic missions will suffer a penalty. We should cancel a few missions so that there is no shortage.";
/*     */ 
/*     */   
/*  48 */   private static CharSequence ¤¤support = "Gather Support";
/*  49 */   private static CharSequence ¤¤supportD = "Gathers support in a region, so that it will be more inclined to be ruled by you in the future.";
/*     */   
/*  51 */   private static CharSequence ¤¤assasinate = "Assassinate";
/*  52 */   private static CharSequence ¤¤assasinateD = "Assassinate a the current ruler. Has a small chance of succeeding and failed attempts will decrease the royalty's opinion of you severely.";
/*  53 */   private static CharSequence ¤¤assasinateDex = "Assassination attempts per year: ";
/*  54 */   private static CharSequence ¤¤flatter = "Flatter";
/*  55 */   private static CharSequence ¤¤flatterD = "Flattering a royalty will increase their opinion of you and your faction.";
/*     */   
/*  57 */   private static CharSequence ¤¤sab = "Sabotage";
/*  58 */   private static CharSequence ¤¤sabD = "Sabotage and insult a royalty to decrease their opinion of you.";
/*     */ 
/*     */ 
/*     */   
/*  62 */   private int mDay = -60;
/*     */   static {
/*  64 */     D.ts(Emissaries.class);
/*     */   }
/*     */   
/*  67 */   private double penalty = 1.0D;
/*     */   
/*  69 */   public final EmiTypeReg assimilate = new EmiTypeReg(
/*  70 */       (SPRITE)(UI.icons()).s.fist.createColored((COLOR)new ColorImp(40, 40, 120)), 
/*  71 */       ¤¤support, ¤¤supportD)
/*     */     {
/*     */     
/*     */     };
/*     */   
/*  76 */   public final EmiTypeRoy assasinate = new EmiTypeRoy(
/*  77 */       (SPRITE)(UI.icons()).s.death.createColored((COLOR)new ColorImp(120, 20, 20)), 
/*  78 */       ¤¤assasinate, ¤¤assasinateD)
/*     */     {
/*     */       public void hover(Royalty t, GUI_BOX text)
/*     */       {
/*  82 */         super.hover(t, text);
/*  83 */         GBox b = (GBox)text;
/*  84 */         b.textLL(Emissaries.¤¤assasinateDex);
/*  85 */         b.add((SPRITE)GFORMAT.f(b.text(), ROPINION.EMMI().assasinationsPerYear(t, 1.0D)));
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*  91 */   public final EmiTypeRoy flatter = new EmiTypeRoyOp(
/*  92 */       (SPRITE)(UI.icons()).s.heart.createColored((COLOR)new ColorImp(120, 40, 120)), 
/*  93 */       ¤¤flatter, ¤¤flatterD)
/*     */     {
/*     */     
/*     */     };
/*     */   
/*  98 */   public final EmiTypeRoy sabotage = new EmiTypeRoyOp(
/*  99 */       (SPRITE)(UI.icons()).s.cog.createColored((COLOR)new ColorImp(120, 100, 20)), 
/* 100 */       ¤¤sab, ¤¤sabD)
/*     */     {
/*     */     
/*     */     };
/*     */   
/* 105 */   public final LIST<EmiTypeRoy> roys = (LIST<EmiTypeRoy>)new ArrayList((Object[])new EmiTypeRoy[] { this.assasinate, this.flatter, this.sabotage });
/* 106 */   public final LIST<EmiTypeReg> regs = (LIST<EmiTypeReg>)new ArrayList(this.assimilate);
/* 107 */   public final LIST<EmiType<?>> all = (LIST<EmiType<?>>)new ArrayList((Object[])new EmiType[] { this.assimilate, this.assasinate, this.flatter, this.sabotage });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final IUpdater upRoy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final IUpdater upReg;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int viewI;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final SAVABLE saver;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Emissaries() {
/* 203 */     this.upRoy = new IUpdater(FACTIONS.MAX() * 4, 120.0D)
/*     */       {
/*     */         protected void update(int i, double timeSinceLast)
/*     */         {
/* 207 */           Faction f = FACTIONS.getByIndex(i / 4);
/*     */           
/* 209 */           if (f instanceof FactionNPC) {
/* 210 */             FactionNPC ff = (FactionNPC)f;
/* 211 */             if (ff == null || !ff.isActive() || ff.court().all().get(i % 4) == null) {
/* 212 */               for (EmiTypeRoy t : Emissaries.this.roys) {
/* 213 */                 t.set(i, 0);
/*     */               }
/*     */             }
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/* 220 */     this.upReg = new IUpdater(1023, 120.0D)
/*     */       {
/*     */         protected void update(int i, double timeSinceLast)
/*     */         {
/* 224 */           Region reg = WORLD.REGIONS().getByIndex(i);
/* 225 */           if (reg == null || !reg.active() || reg.faction() == FACTIONS.player()) {
/* 226 */             for (EmiTypeReg t : Emissaries.this.regs) {
/* 227 */               t.set(reg, 0);
/*     */             }
/*     */           }
/*     */         }
/*     */       };
/*     */     
/* 233 */     this.viewI = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 289 */     this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/* 293 */           file.i(Emissaries.this.mDay);
/* 294 */           for (EmiType<?> t : Emissaries.this.all) {
/* 295 */             t.save(file);
/*     */           }
/*     */         }
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/* 300 */           Emissaries.this.mDay = file.i();
/* 301 */           for (EmiType<?> t : Emissaries.this.all) {
/* 302 */             t.load(file);
/*     */           }
/*     */         }
/*     */         
/*     */         public void clear() {
/* 307 */           Emissaries.this.mDay = -60;
/* 308 */           for (EmiType<?> t : Emissaries.this.all)
/* 309 */             t.clear(); 
/*     */         }
/*     */       };
/*     */     for (EmiType<?> t : this.all) {
/*     */       double max = -1000000.0D;
/*     */       final double maxI = -1.0D / max;
/*     */       BValue.BValueFaction bValueFaction = new BValue.BValueFaction((BOOSTABLES.CIVICS()).DIPLOMACY) {
/*     */           public double vGet(Player f) {
/*     */             return t.total() * maxI;
/*     */           }
/*     */           
/*     */           public double vGet(FactionNPC f) {
/*     */             return 0.0D;
/*     */           }
/*     */         };
/*     */       (new BoosterValue((BValue)bValueFaction, new BSourceInfo(t.name, t.icon), 0.0D, -1000000.0D, false)).add((BOOSTABLES.CIVICS()).DIPLOMACY);
/*     */     } 
/*     */     IDebugPanel.add("diplomacy + 10000", new ACTION() {
/*     */           public void exe() {
/*     */             BValue.BValuePlayerOnly bValuePlayerOnly = new BValue.BValuePlayerOnly() {
/*     */                 public double vGet(Player f) {
/*     */                   return 1.0D;
/*     */                 }
/*     */                 
/*     */                 public double vGet(FactionNPC f) {
/*     */                   return 0.0D;
/*     */                 }
/*     */               };
/*     */             (new BoosterValue((BValue)bValuePlayerOnly, new BSourceInfo("cheat", (SPRITE)(UI.icons()).s.admin), 0.0D, 10000.0D, false)).add((BOOSTABLES.CIVICS()).DIPLOMACY);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public double penaltyMul() {
/*     */     if (VIEW.RI() != this.viewI) {
/*     */       this.viewI = VIEW.RI();
/*     */       double am = (BOOSTABLES.CIVICS()).DIPLOMACY.get((BOOSTABLE_O)FACTIONS.player());
/*     */       if (am < 0.0D) {
/*     */         am = Math.floor(am);
/*     */         int tot = 0;
/*     */         for (EmiType<?> t : this.all)
/*     */           tot += t.total(); 
/*     */         this.penalty = -am / tot;
/*     */         this.penalty = CLAMP.d(this.penalty, 0.0D, 1.0D);
/*     */         this.penalty = 1.0D - this.penalty;
/*     */       } else {
/*     */         this.penalty = 1.0D;
/*     */       } 
/*     */     } 
/*     */     return this.penalty;
/*     */   }
/*     */   
/*     */   public int available() {
/*     */     return (int)(BOOSTABLES.CIVICS()).DIPLOMACY.get((BOOSTABLE_O)FACTIONS.player());
/*     */   }
/*     */   
/*     */   public int produced() {
/*     */     return (int)(BOOSTABLES.CIVICS()).DIPLOMACY.get((BOOSTABLE_O)FACTIONS.player()) + spent();
/*     */   }
/*     */   
/*     */   public int spent() {
/*     */     int am = 0;
/*     */     for (EmiType<?> t : this.all)
/*     */       am += t.total(); 
/*     */     return am;
/*     */   }
/*     */   
/*     */   public int spent(FactionNPC f) {
/*     */     int am = 0;
/*     */     for (EmiTypeRoy t : this.roys)
/*     */       am += t.total(f); 
/*     */     return am;
/*     */   }
/*     */   
/*     */   public void update(double ds) {
/*     */     this.upReg.update(ds);
/*     */     this.upRoy.update(ds);
/*     */     if (penaltyMul() < 1.0D && Math.abs(TIME.days().bitsSinceStart() - this.mDay) > 10) {
/*     */       (new MessageText(¤¤low)).paragraph(¤¤lowD).send();
/*     */       this.mDay = TIME.days().bitsSinceStart();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\emmi\Emissaries.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */