/*     */ package settlement.room.main;
/*     */ 
/*     */ import game.GameDisposable;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoosterValue;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ import util.updating.IUpdater;
/*     */ import view.ui.message.MessageText;
/*     */ 
/*     */ public final class BonusExperience
/*     */   implements SAVABLE {
/*  30 */   private static CharSequence ¤¤name = "¤Experience";
/*  31 */   private static CharSequence ¤¤mGainedTitle = "¤Experience Gained";
/*     */   
/*  33 */   private static CharSequence ¤¤mGainedBody = "¤We now employ over {0} in our {1}, and as a result, this combined experience is boosting performance. Boosting will continue to increase up until {2} employees.";
/*     */   
/*  35 */   private static CharSequence ¤¤mLostTitle = "¤Experience Lost";
/*     */ 
/*     */   
/*  38 */   private static CharSequence ¤¤mLostBody = "¤Since the employees of our {0} have plummeted, performance boosts from experience has been lost.";
/*     */   
/*     */   static {
/*  41 */     D.ts(BonusExperience.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  51 */   private final int[] currents = Alloc.ii(all.size());
/*  52 */   private byte[] sent = Alloc.bb(all.size());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  58 */   private final IUpdater up = new IUpdater(all.size(), TIME.secondsPerDay())
/*     */     {
/*     */       
/*     */       protected void update(int index, double timeSinceLast)
/*     */       {
/*  63 */         BonusExperience.RoomExperienceBonus bo = (BonusExperience.RoomExperienceBonus)BonusExperience.all.get(index);
/*     */         
/*  65 */         int am = bo.blue.employment().employed();
/*     */         
/*  67 */         if (BonusExperience.this.currents[index] < bo.minEmployed && am >= bo.minEmployed && (BonusExperience.this.sent[index] & 0x1) == 0) {
/*  68 */           MessageText m = new MessageText(BonusExperience.¤¤mGainedTitle);
/*  69 */           Str s = Str.TMP;
/*  70 */           s.clear();
/*  71 */           s.add(BonusExperience.¤¤mGainedBody);
/*  72 */           s.insert(0, bo.minEmployed);
/*  73 */           s.insert(1, bo.blue.info.names);
/*  74 */           s.insert(2, bo.maxEmployed);
/*  75 */           m.paragraph((CharSequence)s);
/*  76 */           m.send();
/*  77 */           BonusExperience.this.sent[index] = (byte)(BonusExperience.this.sent[index] | 0x1);
/*  78 */         } else if (BonusExperience.this.currents[index] >= bo.minEmployed && am < bo.minEmployed && (BonusExperience.this.sent[index] & 0x2) == 0) {
/*  79 */           MessageText m = new MessageText(BonusExperience.¤¤mLostTitle);
/*     */           
/*  81 */           Str s = Str.TMP;
/*  82 */           s.clear();
/*  83 */           s.add(BonusExperience.¤¤mLostBody);
/*  84 */           s.insert(0, bo.blue.info.names);
/*     */           
/*  86 */           m.paragraph((CharSequence)s);
/*  87 */           m.send();
/*  88 */           BonusExperience.this.sent[index] = (byte)(BonusExperience.this.sent[index] | 0x2);
/*     */         } 
/*  90 */         BonusExperience.this.currents[index] = am;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void update(double ds) {
/*  98 */     this.up.update(ds);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 103 */     file.isE(this.currents);
/* 104 */     file.bsE(this.sent);
/* 105 */     this.up.save(file);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 111 */     file.isE(this.currents);
/* 112 */     file.bsE(this.sent);
/* 113 */     this.up.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 118 */     Arrays.fill(this.currents, 0);
/* 119 */     Arrays.fill(this.sent, (byte)0);
/*     */   }
/*     */   
/* 122 */   private static final ArrayListGrower<RoomExperienceBonus> all = new ArrayListGrower();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<RoomExperienceBonus> ALL() {
/* 134 */     return (LIST<RoomExperienceBonus>)all;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class RoomExperienceBonus
/*     */   {
/*     */     public final double bonus;
/*     */     
/*     */     public final int maxEmployed;
/*     */     
/*     */     public final int minEmployed;
/*     */     private final double ie;
/*     */     public final RoomBlueprintImp blue;
/*     */     public final Boostable boostable;
/*     */     
/*     */     public RoomExperienceBonus(final RoomBlueprintImp blue, Json data, Boostable boostable) {
/* 150 */       BonusExperience.all.add(this);
/* 151 */       this.blue = blue;
/* 152 */       this.boostable = boostable;
/*     */ 
/*     */       
/* 155 */       int ma = 1000;
/* 156 */       double bo = 1.0D;
/*     */       
/* 158 */       if (data.has("EXPERIENCE_BONUS")) {
/* 159 */         data = data.json("EXPERIENCE_BONUS");
/* 160 */         ma = data.i("MAX_EMPLOYEES", 50, 2147483647);
/* 161 */         bo = data.d("BONUS");
/*     */       } 
/*     */       
/* 164 */       this.maxEmployed = ma;
/* 165 */       this.minEmployed = 50;
/* 166 */       this.bonus = bo;
/* 167 */       this.ie = 1.0D / (this.maxEmployed - this.minEmployed);
/* 168 */       BValue.BValueFaction bValueFaction = new BValue.BValueFaction(boostable)
/*     */         {
/*     */           public double vGet(Player f)
/*     */           {
/* 172 */             return CLAMP.d((blue.employment().employed() - BonusExperience.RoomExperienceBonus.this.minEmployed) * BonusExperience.RoomExperienceBonus.this.ie, 0.0D, 1.0D);
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(FactionNPC f) {
/* 177 */             return 0.0D;
/*     */           }
/*     */         };
/*     */       
/* 181 */       BoosterValue bos = new BoosterValue((BValue)bValueFaction, new BSourceInfo(BonusExperience.¤¤name, (SPRITE)(UI.icons()).s.clock), 0.0D, this.bonus, false);
/*     */       
/* 183 */       bos.add(boostable);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\BonusExperience.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */