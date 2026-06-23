/*     */ package game.events.killer;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.paths.PATHS;
/*     */ import init.race.Race;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.thing.ThingsCorpses;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.StrInserter;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.Dic;
/*     */ import view.ui.message.MessageSection;
/*     */ import view.ui.message.MessageText;
/*     */ 
/*     */ 
/*     */ final class Messenger
/*     */ {
/*     */   private final Insert[] ins;
/*     */   private final M mFirst;
/*     */   private final M mSecond;
/*     */   private final M mAgain;
/*     */   private final M mSuspect;
/*     */   private final M mSuspectFail;
/*     */   private final M mSuspectSuccess;
/*     */   private final M mColdCase;
/*     */   
/*     */   public Messenger() {
/*  33 */     Json js = new Json(PATHS.TEXT_MISC().getFolder("serialKiller").gets("_INFO"));
/*  34 */     this.mFirst = new M(js.json("FIRST"));
/*  35 */     this.mSecond = new M(js.json("SECOND"));
/*  36 */     this.mAgain = new M(js.json("AGAIN"));
/*  37 */     this.mSuspect = new M(js.json("SUSPECT"));
/*  38 */     this.mSuspectFail = new M(js.json("SUSPECT_FAIL"));
/*  39 */     this.mSuspectSuccess = new M(js.json("CAUGHT"));
/*  40 */     this.mColdCase = new M(js.json("COLD"));
/*     */ 
/*     */     
/*  43 */     this.ins = new Insert[] {
/*  44 */         new Insert("VICTIM_NAME")
/*     */         {
/*     */           public void set(Messenger.Data t, Str str) {
/*  47 */             str.add(STATS.APPEARANCE().name(t.victim.indu()));
/*     */           }
/*     */         },
/*  50 */         new Insert("VICTIM_AGE")
/*     */         {
/*     */           public void set(Messenger.Data t, Str str) {
/*  53 */             str.add((int)Math.ceil((STATS.POP()).age.years.getD(t.victim.indu())));
/*     */           }
/*     */         },
/*  56 */         new Insert("VICTIM_RACE")
/*     */         {
/*     */           public void set(Messenger.Data t, Str str) {
/*  59 */             str.add(t.race.info.name);
/*     */           }
/*     */         },
/*  62 */         new Insert("KILLER_SIGNATURE")
/*     */         {
/*     */           public void set(Messenger.Data t, Str str) {
/*  65 */             str.add(t.type.method);
/*     */           }
/*     */         },
/*  68 */         new Insert("KILLER_ALIAS")
/*     */         {
/*     */           public void set(Messenger.Data t, Str str) {
/*  71 */             str.add(t.type.name);
/*     */           }
/*     */         },
/*  74 */         new Insert("KILLER_NAME")
/*     */         {
/*     */           public void set(Messenger.Data t, Str str) {
/*  77 */             str.add(STATS.APPEARANCE().name(t.killer.indu()));
/*     */           }
/*     */         },
/*  80 */         new Insert("SUSPECT_NAME")
/*     */         {
/*     */           public void set(Messenger.Data t, Str str) {
/*  83 */             CharSequence s = (t.suspect != null) ? STATS.APPEARANCE().name(t.suspect.indu()) : Dic.empty;
/*  84 */             str.add(s);
/*     */           }
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void murder(Data data) {
/*  94 */     M m = this.mFirst;
/*  95 */     if (data.murders == 2) {
/*  96 */       m = this.mSecond;
/*  97 */     } else if (data.murders > 2) {
/*  98 */       m = this.mAgain;
/*     */     } 
/* 100 */     Str s = Str.TMP;
/* 101 */     s.clear().add(m.body); byte b; int i;
/*     */     Insert[] arrayOfInsert;
/* 103 */     for (i = (arrayOfInsert = this.ins).length, b = 0; b < i; ) { Insert insert = arrayOfInsert[b]; do {  }
/* 104 */       while (insert.insert(data, s));
/*     */ 
/*     */       
/*     */       b++; }
/*     */ 
/*     */     
/* 110 */     MessageText mm = (new MessageText(m.title)).paragraph((CharSequence)s);
/* 111 */     s.clear();
/* 112 */     s.add('"').add(data.type.messages[data.murders - 1]).add('"').NL().s().s().s().s().add('-').add(data.type.name);
/* 113 */     mm.paragraph((CharSequence)s);
/* 114 */     mm.send();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void murderSuspect(Data data) {
/* 120 */     M m = this.mFirst;
/* 121 */     if (data.murders == 2) {
/* 122 */       m = this.mSecond;
/* 123 */     } else if (data.murders > 2) {
/* 124 */       m = this.mAgain;
/*     */     } 
/* 126 */     Str s = Str.TMP;
/* 127 */     s.clear().add(m.body); byte b1; int i;
/*     */     Insert[] arrayOfInsert1;
/* 129 */     for (i = (arrayOfInsert1 = this.ins).length, b1 = 0; b1 < i; ) { Insert insert = arrayOfInsert1[b1]; do {  }
/* 130 */       while (insert.insert(data, s));
/*     */       
/*     */       b1++; }
/*     */     
/* 134 */     String mess1 = String.valueOf(s);
/* 135 */     s.clear();
/* 136 */     s.add('"').add(data.type.messages[data.murders]).add('"').NL().s().s().s().s().add('-').add(data.type.name);
/* 137 */     String mess2 = String.valueOf(s);
/*     */     
/* 139 */     s.clear();
/* 140 */     s.add(this.mSuspect.body); byte b2; int j; Insert[] arrayOfInsert2;
/* 141 */     for (j = (arrayOfInsert2 = this.ins).length, b2 = 0; b2 < j; ) { Insert insert = arrayOfInsert2[b2]; do {  }
/* 142 */       while (insert.insert(data, s));
/*     */       b2++; }
/*     */     
/* 145 */     (new mSuspect(m.title, mess1, mess2, String.valueOf(s), data.suspect.id(), data.murders, data.killer.id())).send();
/*     */   }
/*     */ 
/*     */   
/*     */   public static class mSuspect
/*     */     extends MessageSection
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private final String mess1;
/*     */     
/*     */     private final String mess2;
/*     */     private final String quest;
/*     */     private final int supsect;
/*     */     private final int murders;
/*     */     private final int killer;
/*     */     
/*     */     mSuspect(CharSequence title, CharSequence mess1, CharSequence mess2, CharSequence quest, int suspect, int murders, int killer) {
/* 163 */       super(title);
/* 164 */       this.mess1 = String.valueOf(mess1);
/* 165 */       this.mess2 = String.valueOf(mess2);
/* 166 */       this.quest = String.valueOf(quest);
/* 167 */       this.supsect = suspect;
/* 168 */       this.murders = murders;
/* 169 */       this.killer = killer;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void make(GuiSection section) {
/* 174 */       paragraph(this.mess1);
/* 175 */       paragraph(this.mess2);
/* 176 */       paragraph(this.quest);
/*     */       
/* 178 */       section.addRelBody(16, DIR.S, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤Yes)
/*     */           {
/*     */             protected void clickA() {
/* 181 */               if (Messenger.mSuspect.this.murders == (GAME.events()).killer.murders() && (GAME.events()).killer.theKiller() != null && (GAME.events()).killer.theKiller().id() == Messenger.mSuspect.this.killer)
/* 182 */                 (GAME.events()).killer.setSuspect(Messenger.mSuspect.this.supsect); 
/* 183 */               Messenger.mSuspect.this.close();
/*     */             }
/*     */             
/*     */             protected void renAction() {
/* 187 */               activeSet(((GAME.events()).killer.suspect() == -1 && Messenger.mSuspect.this.murders == (GAME.events()).killer.murders() && (GAME.events()).killer.theKiller() != null && (GAME.events()).killer.theKiller().id() == Messenger.mSuspect.this.killer));
/*     */             }
/*     */           });
/*     */       
/* 191 */       section.addRelBody(16, DIR.S, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤No)
/*     */           {
/*     */             protected void clickA() {
/* 194 */               Messenger.mSuspect.this.close();
/*     */             }
/*     */             
/*     */             protected void renAction() {
/* 198 */               activeSet(((GAME.events()).killer.suspect() == -1 && Messenger.mSuspect.this.murders == (GAME.events()).killer.murders() && (GAME.events()).killer.theKiller() != null && (GAME.events()).killer.theKiller().id() == Messenger.mSuspect.this.killer));
/*     */             }
/*     */           });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void over(Data data) {
/* 210 */     M m = this.mColdCase;
/* 211 */     Str s = Str.TMP;
/* 212 */     s.clear().add(m.body); byte b; int i;
/*     */     Insert[] arrayOfInsert;
/* 214 */     for (i = (arrayOfInsert = this.ins).length, b = 0; b < i; ) { Insert insert = arrayOfInsert[b];
/* 215 */       insert.insert(data, s);
/*     */       b++; }
/*     */     
/* 218 */     (new MessageText(m.title)).paragraph((CharSequence)s).send();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void caught(Data data) {
/* 224 */     M m = this.mSuspectSuccess;
/* 225 */     Str s = Str.TMP;
/* 226 */     s.clear().add(m.body); byte b; int i;
/*     */     Insert[] arrayOfInsert;
/* 228 */     for (i = (arrayOfInsert = this.ins).length, b = 0; b < i; ) { Insert insert = arrayOfInsert[b];
/* 229 */       insert.insert(data, s);
/*     */       b++; }
/*     */     
/* 232 */     (new MessageText(m.title)).paragraph((CharSequence)s).send();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void fail(Data data) {
/* 238 */     M m = this.mSuspectFail;
/* 239 */     Str s = Str.TMP;
/* 240 */     s.clear().add(m.body); byte b; int i;
/*     */     Insert[] arrayOfInsert;
/* 242 */     for (i = (arrayOfInsert = this.ins).length, b = 0; b < i; ) { Insert insert = arrayOfInsert[b];
/* 243 */       insert.insert(data, s);
/*     */       b++; }
/*     */     
/* 246 */     (new MessageText(m.title)).paragraph((CharSequence)s).send();
/*     */   }
/*     */ 
/*     */   
/*     */   static class Data
/*     */   {
/*     */     public int murders;
/*     */     public Humanoid suspect;
/*     */     public Humanoid killer;
/*     */     public ThingsCorpses.Corpse victim;
/*     */     public Race race;
/*     */     public KillerType type;
/*     */   }
/*     */   
/*     */   private static abstract class Insert
/*     */     extends StrInserter<Data>
/*     */   {
/*     */     public Insert(String key) {
/* 264 */       super(key);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class M
/*     */   {
/*     */     public final CharSequence title;
/*     */     public final CharSequence body;
/*     */     
/*     */     public M(Json json) {
/* 275 */       this.title = json.text("TITLE");
/* 276 */       this.body = json.text("BODY");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\killer\Messenger.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */