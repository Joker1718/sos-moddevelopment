/*      */ package org.lwjgl.openal;
/*      */ 
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class EXTEfx
/*      */ {
/*      */   public static final int ALC_EFX_MAJOR_VERSION = 131073;
/*      */   public static final int ALC_EFX_MINOR_VERSION = 131074;
/*      */   public static final int ALC_MAX_AUXILIARY_SENDS = 131075;
/*      */   public static final int AL_METERS_PER_UNIT = 131076;
/*      */   public static final int AL_DIRECT_FILTER = 131077;
/*      */   public static final int AL_AUXILIARY_SEND_FILTER = 131078;
/*      */   public static final int AL_AIR_ABSORPTION_FACTOR = 131079;
/*      */   public static final int AL_ROOM_ROLLOFF_FACTOR = 131080;
/*      */   public static final int AL_CONE_OUTER_GAINHF = 131081;
/*      */   public static final int AL_DIRECT_FILTER_GAINHF_AUTO = 131082;
/*      */   public static final int AL_AUXILIARY_SEND_FILTER_GAIN_AUTO = 131083;
/*      */   public static final int AL_AUXILIARY_SEND_FILTER_GAINHF_AUTO = 131084;
/*      */   public static final int AL_EFFECTSLOT_NULL = 0;
/*      */   public static final int AL_EFFECTSLOT_EFFECT = 1;
/*      */   public static final int AL_EFFECTSLOT_GAIN = 2;
/*      */   public static final int AL_EFFECTSLOT_AUXILIARY_SEND_AUTO = 3;
/*      */   public static final int AL_REVERB_DENSITY = 1;
/*      */   public static final int AL_REVERB_DIFFUSION = 2;
/*      */   public static final int AL_REVERB_GAIN = 3;
/*      */   public static final int AL_REVERB_GAINHF = 4;
/*      */   public static final int AL_REVERB_DECAY_TIME = 5;
/*      */   public static final int AL_REVERB_DECAY_HFRATIO = 6;
/*      */   public static final int AL_REVERB_REFLECTIONS_GAIN = 7;
/*      */   public static final int AL_REVERB_REFLECTIONS_DELAY = 8;
/*      */   public static final int AL_REVERB_LATE_REVERB_GAIN = 9;
/*      */   public static final int AL_REVERB_LATE_REVERB_DELAY = 10;
/*      */   public static final int AL_REVERB_AIR_ABSORPTION_GAINHF = 11;
/*      */   public static final int AL_REVERB_ROOM_ROLLOFF_FACTOR = 12;
/*      */   public static final int AL_REVERB_DECAY_HFLIMIT = 13;
/*      */   public static final int AL_EAXREVERB_DENSITY = 1;
/*      */   public static final int AL_EAXREVERB_DIFFUSION = 2;
/*      */   public static final int AL_EAXREVERB_GAIN = 3;
/*      */   public static final int AL_EAXREVERB_GAINHF = 4;
/*      */   public static final int AL_EAXREVERB_GAINLF = 5;
/*      */   public static final int AL_EAXREVERB_DECAY_TIME = 6;
/*      */   public static final int AL_EAXREVERB_DECAY_HFRATIO = 7;
/*      */   public static final int AL_EAXREVERB_DECAY_LFRATIO = 8;
/*      */   public static final int AL_EAXREVERB_REFLECTIONS_GAIN = 9;
/*      */   public static final int AL_EAXREVERB_REFLECTIONS_DELAY = 10;
/*      */   public static final int AL_EAXREVERB_REFLECTIONS_PAN = 11;
/*      */   public static final int AL_EAXREVERB_LATE_REVERB_GAIN = 12;
/*      */   public static final int AL_EAXREVERB_LATE_REVERB_DELAY = 13;
/*      */   public static final int AL_EAXREVERB_LATE_REVERB_PAN = 14;
/*      */   public static final int AL_EAXREVERB_ECHO_TIME = 15;
/*      */   public static final int AL_EAXREVERB_ECHO_DEPTH = 16;
/*      */   public static final int AL_EAXREVERB_MODULATION_TIME = 17;
/*      */   public static final int AL_EAXREVERB_MODULATION_DEPTH = 18;
/*      */   public static final int AL_EAXREVERB_AIR_ABSORPTION_GAINHF = 19;
/*      */   public static final int AL_EAXREVERB_HFREFERENCE = 20;
/*      */   public static final int AL_EAXREVERB_LFREFERENCE = 21;
/*      */   public static final int AL_EAXREVERB_ROOM_ROLLOFF_FACTOR = 22;
/*      */   public static final int AL_EAXREVERB_DECAY_HFLIMIT = 23;
/*      */   public static final int AL_CHORUS_WAVEFORM = 1;
/*      */   public static final int AL_CHORUS_PHASE = 2;
/*      */   public static final int AL_CHORUS_RATE = 3;
/*      */   public static final int AL_CHORUS_DEPTH = 4;
/*      */   public static final int AL_CHORUS_FEEDBACK = 5;
/*      */   public static final int AL_CHORUS_DELAY = 6;
/*      */   public static final int AL_DISTORTION_EDGE = 1;
/*      */   public static final int AL_DISTORTION_GAIN = 2;
/*      */   public static final int AL_DISTORTION_LOWPASS_CUTOFF = 3;
/*      */   public static final int AL_DISTORTION_EQCENTER = 4;
/*      */   public static final int AL_DISTORTION_EQBANDWIDTH = 5;
/*      */   public static final int AL_ECHO_DELAY = 1;
/*      */   public static final int AL_ECHO_LRDELAY = 2;
/*      */   public static final int AL_ECHO_DAMPING = 3;
/*      */   public static final int AL_ECHO_FEEDBACK = 4;
/*      */   public static final int AL_ECHO_SPREAD = 5;
/*      */   public static final int AL_FLANGER_WAVEFORM = 1;
/*      */   public static final int AL_FLANGER_PHASE = 2;
/*      */   public static final int AL_FLANGER_RATE = 3;
/*      */   public static final int AL_FLANGER_DEPTH = 4;
/*      */   public static final int AL_FLANGER_FEEDBACK = 5;
/*      */   public static final int AL_FLANGER_DELAY = 6;
/*      */   public static final int AL_FREQUENCY_SHIFTER_FREQUENCY = 1;
/*      */   public static final int AL_FREQUENCY_SHIFTER_LEFT_DIRECTION = 2;
/*      */   public static final int AL_FREQUENCY_SHIFTER_RIGHT_DIRECTION = 3;
/*      */   public static final int AL_VOCMORPHER_PHONEMEA = 1;
/*      */   public static final int AL_VOCMORPHER_PHONEMEA_COARSE_TUNING = 2;
/*      */   public static final int AL_VOCMORPHER_PHONEMEB = 3;
/*      */   public static final int AL_VOCMORPHER_PHONEMEB_COARSE_TUNING = 4;
/*      */   public static final int AL_VOCMORPHER_WAVEFORM = 5;
/*      */   public static final int AL_VOCMORPHER_RATE = 6;
/*      */   public static final int AL_PITCH_SHIFTER_COARSE_TUNE = 1;
/*      */   public static final int AL_PITCH_SHIFTER_FINE_TUNE = 2;
/*      */   public static final int AL_RING_MODULATOR_FREQUENCY = 1;
/*      */   public static final int AL_RING_MODULATOR_HIGHPASS_CUTOFF = 2;
/*      */   public static final int AL_RING_MODULATOR_WAVEFORM = 3;
/*      */   public static final int AL_AUTOWAH_ATTACK_TIME = 1;
/*      */   public static final int AL_AUTOWAH_RELEASE_TIME = 2;
/*      */   public static final int AL_AUTOWAH_RESONANCE = 3;
/*      */   public static final int AL_AUTOWAH_PEAK_GAIN = 4;
/*      */   public static final int AL_COMPRESSOR_ONOFF = 1;
/*      */   public static final int AL_EQUALIZER_LOW_GAIN = 1;
/*      */   public static final int AL_EQUALIZER_LOW_CUTOFF = 2;
/*      */   public static final int AL_EQUALIZER_MID1_GAIN = 3;
/*      */   public static final int AL_EQUALIZER_MID1_CENTER = 4;
/*      */   public static final int AL_EQUALIZER_MID1_WIDTH = 5;
/*      */   public static final int AL_EQUALIZER_MID2_GAIN = 6;
/*      */   public static final int AL_EQUALIZER_MID2_CENTER = 7;
/*      */   public static final int AL_EQUALIZER_MID2_WIDTH = 8;
/*      */   public static final int AL_EQUALIZER_HIGH_GAIN = 9;
/*      */   public static final int AL_EQUALIZER_HIGH_CUTOFF = 10;
/*      */   public static final int AL_EFFECT_FIRST_PARAMETER = 0;
/*      */   public static final int AL_EFFECT_LAST_PARAMETER = 32768;
/*      */   public static final int AL_EFFECT_TYPE = 32769;
/*      */   public static final int AL_EFFECT_NULL = 0;
/*      */   public static final int AL_EFFECT_REVERB = 1;
/*      */   public static final int AL_EFFECT_CHORUS = 2;
/*      */   public static final int AL_EFFECT_DISTORTION = 3;
/*      */   public static final int AL_EFFECT_ECHO = 4;
/*      */   public static final int AL_EFFECT_FLANGER = 5;
/*      */   public static final int AL_EFFECT_FREQUENCY_SHIFTER = 6;
/*      */   public static final int AL_EFFECT_VOCAL_MORPHER = 7;
/*      */   public static final int AL_EFFECT_PITCH_SHIFTER = 8;
/*      */   public static final int AL_EFFECT_RING_MODULATOR = 9;
/*      */   public static final int AL_EFFECT_AUTOWAH = 10;
/*      */   public static final int AL_EFFECT_COMPRESSOR = 11;
/*      */   public static final int AL_EFFECT_EQUALIZER = 12;
/*      */   public static final int AL_EFFECT_EAXREVERB = 32768;
/*      */   public static final int AL_LOWPASS_GAIN = 1;
/*      */   public static final int AL_LOWPASS_GAINHF = 2;
/*      */   public static final int AL_HIGHPASS_GAIN = 1;
/*      */   public static final int AL_HIGHPASS_GAINLF = 2;
/*      */   public static final int AL_BANDPASS_GAIN = 1;
/*      */   public static final int AL_BANDPASS_GAINLF = 2;
/*      */   public static final int AL_BANDPASS_GAINHF = 3;
/*      */   public static final int AL_FILTER_FIRST_PARAMETER = 0;
/*      */   public static final int AL_FILTER_LAST_PARAMETER = 32768;
/*      */   public static final int AL_FILTER_TYPE = 32769;
/*      */   public static final int AL_FILTER_NULL = 0;
/*      */   public static final int AL_FILTER_LOWPASS = 1;
/*      */   public static final int AL_FILTER_HIGHPASS = 2;
/*      */   public static final int AL_FILTER_BANDPASS = 3;
/*      */   public static final float AL_MIN_AIR_ABSORPTION_FACTOR = 0.0F;
/*      */   public static final float AL_MAX_AIR_ABSORPTION_FACTOR = 10.0F;
/*      */   public static final float AL_DEFAULT_AIR_ABSORPTION_FACTOR = 0.0F;
/*      */   public static final float AL_MIN_ROOM_ROLLOFF_FACTOR = 0.0F;
/*      */   public static final float AL_MAX_ROOM_ROLLOFF_FACTOR = 10.0F;
/*      */   public static final float AL_DEFAULT_ROOM_ROLLOFF_FACTOR = 0.0F;
/*      */   public static final float AL_MIN_CONE_OUTER_GAINHF = 0.0F;
/*      */   public static final float AL_MAX_CONE_OUTER_GAINHF = 1.0F;
/*      */   public static final float AL_DEFAULT_CONE_OUTER_GAINHF = 1.0F;
/*      */   public static final int AL_MIN_DIRECT_FILTER_GAINHF_AUTO = 0;
/*      */   public static final int AL_MAX_DIRECT_FILTER_GAINHF_AUTO = 1;
/*      */   public static final int AL_DEFAULT_DIRECT_FILTER_GAINHF_AUTO = 1;
/*      */   public static final int AL_MIN_AUXILIARY_SEND_FILTER_GAIN_AUTO = 0;
/*      */   public static final int AL_MAX_AUXILIARY_SEND_FILTER_GAIN_AUTO = 1;
/*      */   public static final int AL_DEFAULT_AUXILIARY_SEND_FILTER_GAIN_AUTO = 1;
/*      */   public static final int AL_MIN_AUXILIARY_SEND_FILTER_GAINHF_AUTO = 0;
/*      */   public static final int AL_MAX_AUXILIARY_SEND_FILTER_GAINHF_AUTO = 1;
/*      */   public static final int AL_DEFAULT_AUXILIARY_SEND_FILTER_GAINHF_AUTO = 1;
/*      */   public static final float AL_MIN_METERS_PER_UNIT = 1.4E-45F;
/*      */   public static final float AL_MAX_METERS_PER_UNIT = 3.4028235E38F;
/*      */   public static final float AL_DEFAULT_METERS_PER_UNIT = 1.0F;
/*      */   public static final float AL_REVERB_MIN_DENSITY = 0.0F;
/*      */   public static final float AL_REVERB_MAX_DENSITY = 1.0F;
/*      */   public static final float AL_REVERB_DEFAULT_DENSITY = 1.0F;
/*      */   public static final float AL_REVERB_MIN_DIFFUSION = 0.0F;
/*      */   public static final float AL_REVERB_MAX_DIFFUSION = 1.0F;
/*      */   public static final float AL_REVERB_DEFAULT_DIFFUSION = 1.0F;
/*      */   public static final float AL_REVERB_MIN_GAIN = 0.0F;
/*      */   public static final float AL_REVERB_MAX_GAIN = 1.0F;
/*      */   public static final float AL_REVERB_DEFAULT_GAIN = 0.32F;
/*      */   public static final float AL_REVERB_MIN_GAINHF = 0.0F;
/*      */   public static final float AL_REVERB_MAX_GAINHF = 1.0F;
/*      */   public static final float AL_REVERB_DEFAULT_GAINHF = 0.89F;
/*      */   public static final float AL_REVERB_MIN_DECAY_TIME = 0.1F;
/*      */   public static final float AL_REVERB_MAX_DECAY_TIME = 20.0F;
/*      */   public static final float AL_REVERB_DEFAULT_DECAY_TIME = 1.49F;
/*      */   public static final float AL_REVERB_MIN_DECAY_HFRATIO = 0.1F;
/*      */   public static final float AL_REVERB_MAX_DECAY_HFRATIO = 2.0F;
/*      */   public static final float AL_REVERB_DEFAULT_DECAY_HFRATIO = 0.83F;
/*      */   public static final float AL_REVERB_MIN_REFLECTIONS_GAIN = 0.0F;
/*      */   public static final float AL_REVERB_MAX_REFLECTIONS_GAIN = 3.16F;
/*      */   public static final float AL_REVERB_DEFAULT_REFLECTIONS_GAIN = 0.05F;
/*      */   public static final float AL_REVERB_MIN_REFLECTIONS_DELAY = 0.0F;
/*      */   public static final float AL_REVERB_MAX_REFLECTIONS_DELAY = 0.3F;
/*      */   public static final float AL_REVERB_DEFAULT_REFLECTIONS_DELAY = 0.007F;
/*      */   public static final float AL_REVERB_MIN_LATE_REVERB_GAIN = 0.0F;
/*      */   public static final float AL_REVERB_MAX_LATE_REVERB_GAIN = 10.0F;
/*      */   public static final float AL_REVERB_DEFAULT_LATE_REVERB_GAIN = 1.26F;
/*      */   public static final float AL_REVERB_MIN_LATE_REVERB_DELAY = 0.0F;
/*      */   public static final float AL_REVERB_MAX_LATE_REVERB_DELAY = 0.1F;
/*      */   public static final float AL_REVERB_DEFAULT_LATE_REVERB_DELAY = 0.011F;
/*      */   public static final float AL_REVERB_MIN_AIR_ABSORPTION_GAINHF = 0.892F;
/*      */   public static final float AL_REVERB_MAX_AIR_ABSORPTION_GAINHF = 1.0F;
/*      */   public static final float AL_REVERB_DEFAULT_AIR_ABSORPTION_GAINHF = 0.994F;
/*      */   public static final float AL_REVERB_MIN_ROOM_ROLLOFF_FACTOR = 0.0F;
/*      */   public static final float AL_REVERB_MAX_ROOM_ROLLOFF_FACTOR = 10.0F;
/*      */   public static final float AL_REVERB_DEFAULT_ROOM_ROLLOFF_FACTOR = 0.0F;
/*      */   public static final int AL_REVERB_MIN_DECAY_HFLIMIT = 0;
/*      */   public static final int AL_REVERB_MAX_DECAY_HFLIMIT = 1;
/*      */   public static final int AL_REVERB_DEFAULT_DECAY_HFLIMIT = 1;
/*      */   public static final float AL_EAXREVERB_MIN_DENSITY = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_DENSITY = 1.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_DENSITY = 1.0F;
/*      */   public static final float AL_EAXREVERB_MIN_DIFFUSION = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_DIFFUSION = 1.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_DIFFUSION = 1.0F;
/*      */   public static final float AL_EAXREVERB_MIN_GAIN = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_GAIN = 1.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_GAIN = 0.32F;
/*      */   public static final float AL_EAXREVERB_MIN_GAINHF = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_GAINHF = 1.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_GAINHF = 0.89F;
/*      */   public static final float AL_EAXREVERB_MIN_GAINLF = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_GAINLF = 1.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_GAINLF = 1.0F;
/*      */   public static final float AL_EAXREVERB_MIN_DECAY_TIME = 0.1F;
/*      */   public static final float AL_EAXREVERB_MAX_DECAY_TIME = 20.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_DECAY_TIME = 1.49F;
/*      */   public static final float AL_EAXREVERB_MIN_DECAY_HFRATIO = 0.1F;
/*      */   public static final float AL_EAXREVERB_MAX_DECAY_HFRATIO = 2.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_DECAY_HFRATIO = 0.83F;
/*      */   public static final float AL_EAXREVERB_MIN_DECAY_LFRATIO = 0.1F;
/*      */   public static final float AL_EAXREVERB_MAX_DECAY_LFRATIO = 2.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_DECAY_LFRATIO = 1.0F;
/*      */   public static final float AL_EAXREVERB_MIN_REFLECTIONS_GAIN = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_REFLECTIONS_GAIN = 3.16F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_REFLECTIONS_GAIN = 0.05F;
/*      */   public static final float AL_EAXREVERB_MIN_REFLECTIONS_DELAY = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_REFLECTIONS_DELAY = 0.3F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_REFLECTIONS_DELAY = 0.007F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_REFLECTIONS_PAN_XYZ = 0.0F;
/*      */   public static final float AL_EAXREVERB_MIN_LATE_REVERB_GAIN = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_LATE_REVERB_GAIN = 10.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_LATE_REVERB_GAIN = 1.26F;
/*      */   public static final float AL_EAXREVERB_MIN_LATE_REVERB_DELAY = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_LATE_REVERB_DELAY = 0.1F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_LATE_REVERB_DELAY = 0.011F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_LATE_REVERB_PAN_XYZ = 0.0F;
/*      */   public static final float AL_EAXREVERB_MIN_ECHO_TIME = 0.075F;
/*      */   public static final float AL_EAXREVERB_MAX_ECHO_TIME = 0.25F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_ECHO_TIME = 0.25F;
/*      */   public static final float AL_EAXREVERB_MIN_ECHO_DEPTH = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_ECHO_DEPTH = 1.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_ECHO_DEPTH = 0.0F;
/*      */   public static final float AL_EAXREVERB_MIN_MODULATION_TIME = 0.04F;
/*      */   public static final float AL_EAXREVERB_MAX_MODULATION_TIME = 4.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_MODULATION_TIME = 0.25F;
/*      */   public static final float AL_EAXREVERB_MIN_MODULATION_DEPTH = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_MODULATION_DEPTH = 1.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_MODULATION_DEPTH = 0.0F;
/*      */   public static final float AL_EAXREVERB_MIN_AIR_ABSORPTION_GAINHF = 0.892F;
/*      */   public static final float AL_EAXREVERB_MAX_AIR_ABSORPTION_GAINHF = 1.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_AIR_ABSORPTION_GAINHF = 0.994F;
/*      */   public static final float AL_EAXREVERB_MIN_HFREFERENCE = 1000.0F;
/*      */   public static final float AL_EAXREVERB_MAX_HFREFERENCE = 20000.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_HFREFERENCE = 5000.0F;
/*      */   public static final float AL_EAXREVERB_MIN_LFREFERENCE = 20.0F;
/*      */   public static final float AL_EAXREVERB_MAX_LFREFERENCE = 1000.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_LFREFERENCE = 250.0F;
/*      */   public static final float AL_EAXREVERB_MIN_ROOM_ROLLOFF_FACTOR = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_ROOM_ROLLOFF_FACTOR = 10.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_ROOM_ROLLOFF_FACTOR = 0.0F;
/*      */   public static final int AL_EAXREVERB_MIN_DECAY_HFLIMIT = 0;
/*      */   public static final int AL_EAXREVERB_MAX_DECAY_HFLIMIT = 1;
/*      */   public static final int AL_EAXREVERB_DEFAULT_DECAY_HFLIMIT = 1;
/*      */   public static final int AL_CHORUS_WAVEFORM_SINUSOID = 0;
/*      */   public static final int AL_CHORUS_WAVEFORM_TRIANGLE = 1;
/*      */   public static final int AL_CHORUS_MIN_WAVEFORM = 0;
/*      */   public static final int AL_CHORUS_MAX_WAVEFORM = 1;
/*      */   public static final int AL_CHORUS_DEFAULT_WAVEFORM = 1;
/*      */   public static final int AL_CHORUS_MIN_PHASE = -180;
/*      */   public static final int AL_CHORUS_MAX_PHASE = 180;
/*      */   public static final int AL_CHORUS_DEFAULT_PHASE = 90;
/*      */   public static final float AL_CHORUS_MIN_RATE = 0.0F;
/*      */   public static final float AL_CHORUS_MAX_RATE = 10.0F;
/*      */   public static final float AL_CHORUS_DEFAULT_RATE = 1.1F;
/*      */   public static final float AL_CHORUS_MIN_DEPTH = 0.0F;
/*      */   public static final float AL_CHORUS_MAX_DEPTH = 1.0F;
/*      */   public static final float AL_CHORUS_DEFAULT_DEPTH = 0.1F;
/*      */   public static final float AL_CHORUS_MIN_FEEDBACK = -1.0F;
/*      */   public static final float AL_CHORUS_MAX_FEEDBACK = 1.0F;
/*      */   public static final float AL_CHORUS_DEFAULT_FEEDBACK = 0.25F;
/*      */   public static final float AL_CHORUS_MIN_DELAY = 0.0F;
/*      */   public static final float AL_CHORUS_MAX_DELAY = 0.016F;
/*      */   public static final float AL_CHORUS_DEFAULT_DELAY = 0.016F;
/*      */   public static final float AL_DISTORTION_MIN_EDGE = 0.0F;
/*      */   public static final float AL_DISTORTION_MAX_EDGE = 1.0F;
/*      */   public static final float AL_DISTORTION_DEFAULT_EDGE = 0.2F;
/*      */   public static final float AL_DISTORTION_MIN_GAIN = 0.01F;
/*      */   public static final float AL_DISTORTION_MAX_GAIN = 1.0F;
/*      */   public static final float AL_DISTORTION_DEFAULT_GAIN = 0.05F;
/*      */   public static final float AL_DISTORTION_MIN_LOWPASS_CUTOFF = 80.0F;
/*      */   public static final float AL_DISTORTION_MAX_LOWPASS_CUTOFF = 24000.0F;
/*      */   public static final float AL_DISTORTION_DEFAULT_LOWPASS_CUTOFF = 8000.0F;
/*      */   public static final float AL_DISTORTION_MIN_EQCENTER = 80.0F;
/*      */   public static final float AL_DISTORTION_MAX_EQCENTER = 24000.0F;
/*      */   public static final float AL_DISTORTION_DEFAULT_EQCENTER = 3600.0F;
/*      */   public static final float AL_DISTORTION_MIN_EQBANDWIDTH = 80.0F;
/*      */   public static final float AL_DISTORTION_MAX_EQBANDWIDTH = 24000.0F;
/*      */   public static final float AL_DISTORTION_DEFAULT_EQBANDWIDTH = 3600.0F;
/*      */   public static final float AL_ECHO_MIN_DELAY = 0.0F;
/*      */   public static final float AL_ECHO_MAX_DELAY = 0.207F;
/*      */   public static final float AL_ECHO_DEFAULT_DELAY = 0.1F;
/*      */   public static final float AL_ECHO_MIN_LRDELAY = 0.0F;
/*      */   public static final float AL_ECHO_MAX_LRDELAY = 0.404F;
/*      */   public static final float AL_ECHO_DEFAULT_LRDELAY = 0.1F;
/*      */   public static final float AL_ECHO_MIN_DAMPING = 0.0F;
/*      */   public static final float AL_ECHO_MAX_DAMPING = 0.99F;
/*      */   public static final float AL_ECHO_DEFAULT_DAMPING = 0.5F;
/*      */   public static final float AL_ECHO_MIN_FEEDBACK = 0.0F;
/*      */   public static final float AL_ECHO_MAX_FEEDBACK = 1.0F;
/*      */   public static final float AL_ECHO_DEFAULT_FEEDBACK = 0.5F;
/*      */   public static final float AL_ECHO_MIN_SPREAD = -1.0F;
/*      */   public static final float AL_ECHO_MAX_SPREAD = 1.0F;
/*      */   public static final float AL_ECHO_DEFAULT_SPREAD = -1.0F;
/*      */   public static final int AL_FLANGER_WAVEFORM_SINUSOID = 0;
/*      */   public static final int AL_FLANGER_WAVEFORM_TRIANGLE = 1;
/*      */   public static final int AL_FLANGER_MIN_WAVEFORM = 0;
/*      */   public static final int AL_FLANGER_MAX_WAVEFORM = 1;
/*      */   public static final int AL_FLANGER_DEFAULT_WAVEFORM = 1;
/*      */   public static final int AL_FLANGER_MIN_PHASE = -180;
/*      */   public static final int AL_FLANGER_MAX_PHASE = 180;
/*      */   public static final int AL_FLANGER_DEFAULT_PHASE = 0;
/*      */   public static final float AL_FLANGER_MIN_RATE = 0.0F;
/*      */   public static final float AL_FLANGER_MAX_RATE = 10.0F;
/*      */   public static final float AL_FLANGER_DEFAULT_RATE = 0.27F;
/*      */   public static final float AL_FLANGER_MIN_DEPTH = 0.0F;
/*      */   public static final float AL_FLANGER_MAX_DEPTH = 1.0F;
/*      */   public static final float AL_FLANGER_DEFAULT_DEPTH = 1.0F;
/*      */   public static final float AL_FLANGER_MIN_FEEDBACK = -1.0F;
/*      */   public static final float AL_FLANGER_MAX_FEEDBACK = 1.0F;
/*      */   public static final float AL_FLANGER_DEFAULT_FEEDBACK = -0.5F;
/*      */   public static final float AL_FLANGER_MIN_DELAY = 0.0F;
/*      */   public static final float AL_FLANGER_MAX_DELAY = 0.004F;
/*      */   public static final float AL_FLANGER_DEFAULT_DELAY = 0.002F;
/*      */   public static final float AL_FREQUENCY_SHIFTER_MIN_FREQUENCY = 0.0F;
/*      */   public static final float AL_FREQUENCY_SHIFTER_MAX_FREQUENCY = 24000.0F;
/*      */   public static final float AL_FREQUENCY_SHIFTER_DEFAULT_FREQUENCY = 0.0F;
/*      */   public static final int AL_FREQUENCY_SHIFTER_MIN_LEFT_DIRECTION = 0;
/*      */   public static final int AL_FREQUENCY_SHIFTER_MAX_LEFT_DIRECTION = 2;
/*      */   public static final int AL_FREQUENCY_SHIFTER_DEFAULT_LEFT_DIRECTION = 0;
/*      */   public static final int AL_FREQUENCY_SHIFTER_DIRECTION_DOWN = 0;
/*      */   public static final int AL_FREQUENCY_SHIFTER_DIRECTION_UP = 1;
/*      */   public static final int AL_FREQUENCY_SHIFTER_DIRECTION_OFF = 2;
/*      */   public static final int AL_FREQUENCY_SHIFTER_MIN_RIGHT_DIRECTION = 0;
/*      */   public static final int AL_FREQUENCY_SHIFTER_MAX_RIGHT_DIRECTION = 2;
/*      */   public static final int AL_FREQUENCY_SHIFTER_DEFAULT_RIGHT_DIRECTION = 0;
/*      */   public static final int AL_VOCAL_MORPHER_MIN_PHONEMEA = 0;
/*      */   public static final int AL_VOCAL_MORPHER_MAX_PHONEMEA = 29;
/*      */   public static final int AL_VOCAL_MORPHER_DEFAULT_PHONEMEA = 0;
/*      */   public static final int AL_VOCAL_MORPHER_MIN_PHONEMEA_COARSE_TUNING = -24;
/*      */   public static final int AL_VOCAL_MORPHER_MAX_PHONEMEA_COARSE_TUNING = 24;
/*      */   public static final int AL_VOCAL_MORPHER_DEFAULT_PHONEMEA_COARSE_TUNING = 0;
/*      */   public static final int AL_VOCAL_MORPHER_MIN_PHONEMEB = 0;
/*      */   public static final int AL_VOCAL_MORPHER_MAX_PHONEMEB = 29;
/*      */   public static final int AL_VOCAL_MORPHER_DEFAULT_PHONEMEB = 10;
/*      */   public static final int AL_VOCAL_MORPHER_MIN_PHONEMEB_COARSE_TUNING = -24;
/*      */   public static final int AL_VOCAL_MORPHER_MAX_PHONEMEB_COARSE_TUNING = 24;
/*      */   public static final int AL_VOCAL_MORPHER_DEFAULT_PHONEMEB_COARSE_TUNING = 0;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_A = 0;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_E = 1;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_I = 2;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_O = 3;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_U = 4;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_AA = 5;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_AE = 6;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_AH = 7;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_AO = 8;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_EH = 9;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_ER = 10;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_IH = 11;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_IY = 12;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_UH = 13;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_UW = 14;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_B = 15;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_D = 16;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_F = 17;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_G = 18;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_J = 19;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_K = 20;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_L = 21;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_M = 22;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_N = 23;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_P = 24;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_R = 25;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_S = 26;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_T = 27;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_V = 28;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_Z = 29;
/*      */   public static final int AL_VOCAL_MORPHER_WAVEFORM_SINUSOID = 0;
/*      */   public static final int AL_VOCAL_MORPHER_WAVEFORM_TRIANGLE = 1;
/*      */   public static final int AL_VOCAL_MORPHER_WAVEFORM_SAWTOOTH = 2;
/*      */   public static final int AL_VOCAL_MORPHER_MIN_WAVEFORM = 0;
/*      */   public static final int AL_VOCAL_MORPHER_MAX_WAVEFORM = 2;
/*      */   public static final int AL_VOCAL_MORPHER_DEFAULT_WAVEFORM = 0;
/*      */   public static final float AL_VOCAL_MORPHER_MIN_RATE = 0.0F;
/*      */   public static final float AL_VOCAL_MORPHER_MAX_RATE = 10.0F;
/*      */   public static final float AL_VOCAL_MORPHER_DEFAULT_RATE = 1.41F;
/*      */   public static final int AL_PITCH_SHIFTER_MIN_COARSE_TUNE = -12;
/*      */   public static final int AL_PITCH_SHIFTER_MAX_COARSE_TUNE = 12;
/*      */   public static final int AL_PITCH_SHIFTER_DEFAULT_COARSE_TUNE = 12;
/*      */   public static final int AL_PITCH_SHIFTER_MIN_FINE_TUNE = -50;
/*      */   public static final int AL_PITCH_SHIFTER_MAX_FINE_TUNE = 50;
/*      */   public static final int AL_PITCH_SHIFTER_DEFAULT_FINE_TUNE = 0;
/*      */   public static final float AL_RING_MODULATOR_MIN_FREQUENCY = 0.0F;
/*      */   public static final float AL_RING_MODULATOR_MAX_FREQUENCY = 8000.0F;
/*      */   public static final float AL_RING_MODULATOR_DEFAULT_FREQUENCY = 440.0F;
/*      */   public static final float AL_RING_MODULATOR_MIN_HIGHPASS_CUTOFF = 0.0F;
/*      */   public static final float AL_RING_MODULATOR_MAX_HIGHPASS_CUTOFF = 24000.0F;
/*      */   public static final float AL_RING_MODULATOR_DEFAULT_HIGHPASS_CUTOFF = 800.0F;
/*      */   public static final int AL_RING_MODULATOR_SINUSOID = 0;
/*      */   public static final int AL_RING_MODULATOR_SAWTOOTH = 1;
/*      */   public static final int AL_RING_MODULATOR_SQUARE = 2;
/*      */   public static final int AL_RING_MODULATOR_MIN_WAVEFORM = 0;
/*      */   public static final int AL_RING_MODULATOR_MAX_WAVEFORM = 2;
/*      */   public static final int AL_RING_MODULATOR_DEFAULT_WAVEFORM = 0;
/*      */   public static final float AL_AUTOWAH_MIN_ATTACK_TIME = 1.0E-4F;
/*      */   public static final float AL_AUTOWAH_MAX_ATTACK_TIME = 1.0F;
/*      */   public static final float AL_AUTOWAH_DEFAULT_ATTACK_TIME = 0.06F;
/*      */   public static final float AL_AUTOWAH_MIN_RELEASE_TIME = 1.0E-4F;
/*      */   public static final float AL_AUTOWAH_MAX_RELEASE_TIME = 1.0F;
/*      */   public static final float AL_AUTOWAH_DEFAULT_RELEASE_TIME = 0.06F;
/*      */   public static final float AL_AUTOWAH_MIN_RESONANCE = 2.0F;
/*      */   public static final float AL_AUTOWAH_MAX_RESONANCE = 1000.0F;
/*      */   public static final float AL_AUTOWAH_DEFAULT_RESONANCE = 1000.0F;
/*      */   public static final float AL_AUTOWAH_MIN_PEAK_GAIN = 3.0E-5F;
/*      */   public static final float AL_AUTOWAH_MAX_PEAK_GAIN = 31621.0F;
/*      */   public static final float AL_AUTOWAH_DEFAULT_PEAK_GAIN = 11.22F;
/*      */   public static final int AL_COMPRESSOR_MIN_ONOFF = 0;
/*      */   public static final int AL_COMPRESSOR_MAX_ONOFF = 1;
/*      */   public static final int AL_COMPRESSOR_DEFAULT_ONOFF = 1;
/*      */   public static final float AL_EQUALIZER_MIN_LOW_GAIN = 0.126F;
/*      */   public static final float AL_EQUALIZER_MAX_LOW_GAIN = 7.943F;
/*      */   public static final float AL_EQUALIZER_DEFAULT_LOW_GAIN = 1.0F;
/*      */   public static final float AL_EQUALIZER_MIN_LOW_CUTOFF = 50.0F;
/*      */   public static final float AL_EQUALIZER_MAX_LOW_CUTOFF = 800.0F;
/*      */   public static final float AL_EQUALIZER_DEFAULT_LOW_CUTOFF = 200.0F;
/*      */   public static final float AL_EQUALIZER_MIN_MID1_GAIN = 0.126F;
/*      */   public static final float AL_EQUALIZER_MAX_MID1_GAIN = 7.943F;
/*      */   public static final float AL_EQUALIZER_DEFAULT_MID1_GAIN = 1.0F;
/*      */   public static final float AL_EQUALIZER_MIN_MID1_CENTER = 200.0F;
/*      */   public static final float AL_EQUALIZER_MAX_MID1_CENTER = 3000.0F;
/*      */   public static final float AL_EQUALIZER_DEFAULT_MID1_CENTER = 500.0F;
/*      */   public static final float AL_EQUALIZER_MIN_MID1_WIDTH = 0.01F;
/*      */   public static final float AL_EQUALIZER_MAX_MID1_WIDTH = 1.0F;
/*      */   public static final float AL_EQUALIZER_DEFAULT_MID1_WIDTH = 1.0F;
/*      */   public static final float AL_EQUALIZER_MIN_MID2_GAIN = 0.126F;
/*      */   public static final float AL_EQUALIZER_MAX_MID2_GAIN = 7.943F;
/*      */   public static final float AL_EQUALIZER_DEFAULT_MID2_GAIN = 1.0F;
/*      */   public static final float AL_EQUALIZER_MIN_MID2_CENTER = 1000.0F;
/*      */   public static final float AL_EQUALIZER_MAX_MID2_CENTER = 8000.0F;
/*      */   public static final float AL_EQUALIZER_DEFAULT_MID2_CENTER = 3000.0F;
/*      */   public static final float AL_EQUALIZER_MIN_MID2_WIDTH = 0.01F;
/*      */   public static final float AL_EQUALIZER_MAX_MID2_WIDTH = 1.0F;
/*      */   public static final float AL_EQUALIZER_DEFAULT_MID2_WIDTH = 1.0F;
/*      */   public static final float AL_EQUALIZER_MIN_HIGH_GAIN = 0.126F;
/*      */   public static final float AL_EQUALIZER_MAX_HIGH_GAIN = 7.943F;
/*      */   public static final float AL_EQUALIZER_DEFAULT_HIGH_GAIN = 1.0F;
/*      */   public static final float AL_EQUALIZER_MIN_HIGH_CUTOFF = 4000.0F;
/*      */   public static final float AL_EQUALIZER_MAX_HIGH_CUTOFF = 16000.0F;
/*      */   public static final float AL_EQUALIZER_DEFAULT_HIGH_CUTOFF = 6000.0F;
/*      */   public static final float AL_LOWPASS_MIN_GAIN = 0.0F;
/*      */   public static final float AL_LOWPASS_MAX_GAIN = 1.0F;
/*      */   public static final float AL_LOWPASS_DEFAULT_GAIN = 1.0F;
/*      */   public static final float AL_LOWPASS_MIN_GAINHF = 0.0F;
/*      */   public static final float AL_LOWPASS_MAX_GAINHF = 1.0F;
/*      */   public static final float AL_LOWPASS_DEFAULT_GAINHF = 1.0F;
/*      */   public static final float AL_HIGHPASS_MIN_GAIN = 0.0F;
/*      */   public static final float AL_HIGHPASS_MAX_GAIN = 1.0F;
/*      */   public static final float AL_HIGHPASS_DEFAULT_GAIN = 1.0F;
/*      */   public static final float AL_HIGHPASS_MIN_GAINLF = 0.0F;
/*      */   public static final float AL_HIGHPASS_MAX_GAINLF = 1.0F;
/*      */   public static final float AL_HIGHPASS_DEFAULT_GAINLF = 1.0F;
/*      */   public static final float AL_BANDPASS_MIN_GAIN = 0.0F;
/*      */   public static final float AL_BANDPASS_MAX_GAIN = 1.0F;
/*      */   public static final float AL_BANDPASS_DEFAULT_GAIN = 1.0F;
/*      */   public static final float AL_BANDPASS_MIN_GAINHF = 0.0F;
/*      */   public static final float AL_BANDPASS_MAX_GAINHF = 1.0F;
/*      */   public static final float AL_BANDPASS_DEFAULT_GAINHF = 1.0F;
/*      */   public static final float AL_BANDPASS_MIN_GAINLF = 0.0F;
/*      */   public static final float AL_BANDPASS_MAX_GAINLF = 1.0F;
/*      */   public static final float AL_BANDPASS_DEFAULT_GAINLF = 1.0F;
/*      */   
/*      */   protected EXTEfx() {
/*  594 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGenEffects(int n, long effects) {
/*  601 */     long __functionAddress = (AL.getICD()).alGenEffects;
/*  602 */     if (Checks.CHECKS) {
/*  603 */       Checks.check(__functionAddress);
/*      */     }
/*  605 */     JNI.invokePV(n, effects, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenEffects(@NativeType("ALuint *") IntBuffer effects) {
/*  611 */     nalGenEffects(effects.remaining(), MemoryUtil.memAddress(effects));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGenEffects() {
/*  617 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  619 */       IntBuffer effects = stack.callocInt(1);
/*  620 */       nalGenEffects(1, MemoryUtil.memAddress(effects));
/*  621 */       return effects.get(0);
/*      */     } finally {
/*  623 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGenEffectsDirect(long context, int n, long effects) {
/*  631 */     long __functionAddress = (AL.getICD()).alGenEffectsDirect;
/*  632 */     if (Checks.CHECKS) {
/*  633 */       Checks.check(__functionAddress);
/*  634 */       Checks.check(context);
/*      */     } 
/*  636 */     JNI.invokePPV(context, n, effects, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenEffectsDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint *") IntBuffer effects) {
/*  642 */     nalGenEffectsDirect(context, effects.remaining(), MemoryUtil.memAddress(effects));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGenEffectsDirect(@NativeType("ALCcontext *") long context) {
/*  648 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  650 */       IntBuffer effects = stack.callocInt(1);
/*  651 */       nalGenEffectsDirect(context, 1, MemoryUtil.memAddress(effects));
/*  652 */       return effects.get(0);
/*      */     } finally {
/*  654 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalDeleteEffects(int n, long effects) {
/*  662 */     long __functionAddress = (AL.getICD()).alDeleteEffects;
/*  663 */     if (Checks.CHECKS) {
/*  664 */       Checks.check(__functionAddress);
/*      */     }
/*  666 */     JNI.invokePV(n, effects, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteEffects(@NativeType("ALuint *") IntBuffer effects) {
/*  672 */     nalDeleteEffects(effects.remaining(), MemoryUtil.memAddress(effects));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteEffects(@NativeType("ALuint *") int effect) {
/*  678 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  680 */       IntBuffer effects = stack.ints(effect);
/*  681 */       nalDeleteEffects(1, MemoryUtil.memAddress(effects));
/*      */     } finally {
/*  683 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalDeleteEffectsDirect(long context, int n, long effects) {
/*  691 */     long __functionAddress = (AL.getICD()).alDeleteEffectsDirect;
/*  692 */     if (Checks.CHECKS) {
/*  693 */       Checks.check(__functionAddress);
/*  694 */       Checks.check(context);
/*      */     } 
/*  696 */     JNI.invokePPV(context, n, effects, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteEffectsDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint *") IntBuffer effects) {
/*  702 */     nalDeleteEffectsDirect(context, effects.remaining(), MemoryUtil.memAddress(effects));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteEffectsDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint *") int effect) {
/*  708 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  710 */       IntBuffer effects = stack.ints(effect);
/*  711 */       nalDeleteEffectsDirect(context, 1, MemoryUtil.memAddress(effects));
/*      */     } finally {
/*  713 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALboolean")
/*      */   public static boolean alIsEffect(@NativeType("ALuint") int effect) {
/*  722 */     long __functionAddress = (AL.getICD()).alIsEffect;
/*  723 */     if (Checks.CHECKS) {
/*  724 */       Checks.check(__functionAddress);
/*      */     }
/*  726 */     return JNI.invokeZ(effect, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALboolean")
/*      */   public static boolean alIsEffectDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effect) {
/*  734 */     long __functionAddress = (AL.getICD()).alIsEffectDirect;
/*  735 */     if (Checks.CHECKS) {
/*  736 */       Checks.check(__functionAddress);
/*  737 */       Checks.check(context);
/*      */     } 
/*  739 */     return JNI.invokePZ(context, effect, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alEffecti(@NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALint") int value) {
/*  747 */     long __functionAddress = (AL.getICD()).alEffecti;
/*  748 */     if (Checks.CHECKS) {
/*  749 */       Checks.check(__functionAddress);
/*      */     }
/*  751 */     JNI.invokeV(effect, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alEffectiDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALint") int value) {
/*  759 */     long __functionAddress = (AL.getICD()).alEffectiDirect;
/*  760 */     if (Checks.CHECKS) {
/*  761 */       Checks.check(__functionAddress);
/*  762 */       Checks.check(context);
/*      */     } 
/*  764 */     JNI.invokePV(context, effect, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalEffectiv(int effect, int param, long values) {
/*  771 */     long __functionAddress = (AL.getICD()).alEffectiv;
/*  772 */     if (Checks.CHECKS) {
/*  773 */       Checks.check(__functionAddress);
/*      */     }
/*  775 */     JNI.invokePV(effect, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alEffectiv(@NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALint const *") IntBuffer values) {
/*  781 */     if (Checks.CHECKS) {
/*  782 */       Checks.check(values, 1);
/*      */     }
/*  784 */     nalEffectiv(effect, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalEffectivDirect(long context, int effect, int param, long values) {
/*  791 */     long __functionAddress = (AL.getICD()).alEffectivDirect;
/*  792 */     if (Checks.CHECKS) {
/*  793 */       Checks.check(__functionAddress);
/*  794 */       Checks.check(context);
/*      */     } 
/*  796 */     JNI.invokePPV(context, effect, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alEffectivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALint const *") IntBuffer values) {
/*  802 */     if (Checks.CHECKS) {
/*  803 */       Checks.check(values, 1);
/*      */     }
/*  805 */     nalEffectivDirect(context, effect, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alEffectf(@NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALfloat") float value) {
/*  813 */     long __functionAddress = (AL.getICD()).alEffectf;
/*  814 */     if (Checks.CHECKS) {
/*  815 */       Checks.check(__functionAddress);
/*      */     }
/*  817 */     JNI.invokeV(effect, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alEffectfDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALfloat") float value) {
/*  825 */     long __functionAddress = (AL.getICD()).alEffectfDirect;
/*  826 */     if (Checks.CHECKS) {
/*  827 */       Checks.check(__functionAddress);
/*  828 */       Checks.check(context);
/*      */     } 
/*  830 */     JNI.invokePV(context, effect, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalEffectfv(int effect, int param, long values) {
/*  837 */     long __functionAddress = (AL.getICD()).alEffectfv;
/*  838 */     if (Checks.CHECKS) {
/*  839 */       Checks.check(__functionAddress);
/*      */     }
/*  841 */     JNI.invokePV(effect, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alEffectfv(@NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALfloat const *") FloatBuffer values) {
/*  847 */     if (Checks.CHECKS) {
/*  848 */       Checks.check(values, 1);
/*      */     }
/*  850 */     nalEffectfv(effect, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalEffectfvDirect(long context, int effect, int param, long values) {
/*  857 */     long __functionAddress = (AL.getICD()).alEffectfvDirect;
/*  858 */     if (Checks.CHECKS) {
/*  859 */       Checks.check(__functionAddress);
/*  860 */       Checks.check(context);
/*      */     } 
/*  862 */     JNI.invokePPV(context, effect, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alEffectfvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALfloat const *") FloatBuffer values) {
/*  868 */     if (Checks.CHECKS) {
/*  869 */       Checks.check(values, 1);
/*      */     }
/*  871 */     nalEffectfvDirect(context, effect, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetEffecti(int effect, int param, long value) {
/*  878 */     long __functionAddress = (AL.getICD()).alGetEffecti;
/*  879 */     if (Checks.CHECKS) {
/*  880 */       Checks.check(__functionAddress);
/*      */     }
/*  882 */     JNI.invokePV(effect, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffecti(@NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer value) {
/*  888 */     if (Checks.CHECKS) {
/*  889 */       Checks.check(value, 1);
/*      */     }
/*  891 */     nalGetEffecti(effect, param, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGetEffecti(@NativeType("ALuint") int effect, @NativeType("ALenum") int param) {
/*  897 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  899 */       IntBuffer value = stack.callocInt(1);
/*  900 */       nalGetEffecti(effect, param, MemoryUtil.memAddress(value));
/*  901 */       return value.get(0);
/*      */     } finally {
/*  903 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetEffectiDirect(long context, int effect, int param, long value) {
/*  911 */     long __functionAddress = (AL.getICD()).alGetEffectiDirect;
/*  912 */     if (Checks.CHECKS) {
/*  913 */       Checks.check(__functionAddress);
/*  914 */       Checks.check(context);
/*      */     } 
/*  916 */     JNI.invokePPV(context, effect, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffectiDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer value) {
/*  922 */     if (Checks.CHECKS) {
/*  923 */       Checks.check(value, 1);
/*      */     }
/*  925 */     nalGetEffectiDirect(context, effect, param, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGetEffectiDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effect, @NativeType("ALenum") int param) {
/*  931 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  933 */       IntBuffer value = stack.callocInt(1);
/*  934 */       nalGetEffectiDirect(context, effect, param, MemoryUtil.memAddress(value));
/*  935 */       return value.get(0);
/*      */     } finally {
/*  937 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetEffectiv(int effect, int param, long values) {
/*  945 */     long __functionAddress = (AL.getICD()).alGetEffectiv;
/*  946 */     if (Checks.CHECKS) {
/*  947 */       Checks.check(__functionAddress);
/*      */     }
/*  949 */     JNI.invokePV(effect, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffectiv(@NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer values) {
/*  955 */     if (Checks.CHECKS) {
/*  956 */       Checks.check(values, 1);
/*      */     }
/*  958 */     nalGetEffectiv(effect, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetEffectivDirect(long context, int effect, int param, long values) {
/*  965 */     long __functionAddress = (AL.getICD()).alGetEffectivDirect;
/*  966 */     if (Checks.CHECKS) {
/*  967 */       Checks.check(__functionAddress);
/*  968 */       Checks.check(context);
/*      */     } 
/*  970 */     JNI.invokePPV(context, effect, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffectivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer values) {
/*  976 */     if (Checks.CHECKS) {
/*  977 */       Checks.check(values, 1);
/*      */     }
/*  979 */     nalGetEffectivDirect(context, effect, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetEffectf(int effect, int param, long value) {
/*  986 */     long __functionAddress = (AL.getICD()).alGetEffectf;
/*  987 */     if (Checks.CHECKS) {
/*  988 */       Checks.check(__functionAddress);
/*      */     }
/*  990 */     JNI.invokePV(effect, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffectf(@NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALfloat *") FloatBuffer value) {
/*  996 */     if (Checks.CHECKS) {
/*  997 */       Checks.check(value, 1);
/*      */     }
/*  999 */     nalGetEffectf(effect, param, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static float alGetEffectf(@NativeType("ALuint") int effect, @NativeType("ALenum") int param) {
/* 1005 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1007 */       FloatBuffer value = stack.callocFloat(1);
/* 1008 */       nalGetEffectf(effect, param, MemoryUtil.memAddress(value));
/* 1009 */       return value.get(0);
/*      */     } finally {
/* 1011 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetEffectfDirect(long context, int effect, int param, long value) {
/* 1019 */     long __functionAddress = (AL.getICD()).alGetEffectfDirect;
/* 1020 */     if (Checks.CHECKS) {
/* 1021 */       Checks.check(__functionAddress);
/* 1022 */       Checks.check(context);
/*      */     } 
/* 1024 */     JNI.invokePPV(context, effect, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffectfDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALfloat *") FloatBuffer value) {
/* 1030 */     if (Checks.CHECKS) {
/* 1031 */       Checks.check(value, 1);
/*      */     }
/* 1033 */     nalGetEffectfDirect(context, effect, param, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static float alGetEffectfDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effect, @NativeType("ALenum") int param) {
/* 1039 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1041 */       FloatBuffer value = stack.callocFloat(1);
/* 1042 */       nalGetEffectfDirect(context, effect, param, MemoryUtil.memAddress(value));
/* 1043 */       return value.get(0);
/*      */     } finally {
/* 1045 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetEffectfv(int effect, int param, long values) {
/* 1053 */     long __functionAddress = (AL.getICD()).alGetEffectfv;
/* 1054 */     if (Checks.CHECKS) {
/* 1055 */       Checks.check(__functionAddress);
/*      */     }
/* 1057 */     JNI.invokePV(effect, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffectfv(@NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALfloat *") FloatBuffer values) {
/* 1063 */     if (Checks.CHECKS) {
/* 1064 */       Checks.check(values, 1);
/*      */     }
/* 1066 */     nalGetEffectfv(effect, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetEffectfvDirect(long context, int effect, int param, long values) {
/* 1073 */     long __functionAddress = (AL.getICD()).alGetEffectfvDirect;
/* 1074 */     if (Checks.CHECKS) {
/* 1075 */       Checks.check(__functionAddress);
/* 1076 */       Checks.check(context);
/*      */     } 
/* 1078 */     JNI.invokePPV(context, effect, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffectfvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALfloat *") FloatBuffer values) {
/* 1084 */     if (Checks.CHECKS) {
/* 1085 */       Checks.check(values, 1);
/*      */     }
/* 1087 */     nalGetEffectfvDirect(context, effect, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGenFilters(int n, long filters) {
/* 1094 */     long __functionAddress = (AL.getICD()).alGenFilters;
/* 1095 */     if (Checks.CHECKS) {
/* 1096 */       Checks.check(__functionAddress);
/*      */     }
/* 1098 */     JNI.invokePV(n, filters, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenFilters(@NativeType("ALuint *") IntBuffer filters) {
/* 1104 */     nalGenFilters(filters.remaining(), MemoryUtil.memAddress(filters));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGenFilters() {
/* 1110 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1112 */       IntBuffer filters = stack.callocInt(1);
/* 1113 */       nalGenFilters(1, MemoryUtil.memAddress(filters));
/* 1114 */       return filters.get(0);
/*      */     } finally {
/* 1116 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGenFiltersDirect(long context, int n, long filters) {
/* 1124 */     long __functionAddress = (AL.getICD()).alGenFiltersDirect;
/* 1125 */     if (Checks.CHECKS) {
/* 1126 */       Checks.check(__functionAddress);
/* 1127 */       Checks.check(context);
/*      */     } 
/* 1129 */     JNI.invokePPV(context, n, filters, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenFiltersDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint *") IntBuffer filters) {
/* 1135 */     nalGenFiltersDirect(context, filters.remaining(), MemoryUtil.memAddress(filters));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGenFiltersDirect(@NativeType("ALCcontext *") long context) {
/* 1141 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1143 */       IntBuffer filters = stack.callocInt(1);
/* 1144 */       nalGenFiltersDirect(context, 1, MemoryUtil.memAddress(filters));
/* 1145 */       return filters.get(0);
/*      */     } finally {
/* 1147 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalDeleteFilters(int n, long filters) {
/* 1155 */     long __functionAddress = (AL.getICD()).alDeleteFilters;
/* 1156 */     if (Checks.CHECKS) {
/* 1157 */       Checks.check(__functionAddress);
/*      */     }
/* 1159 */     JNI.invokePV(n, filters, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteFilters(@NativeType("ALuint *") IntBuffer filters) {
/* 1165 */     nalDeleteFilters(filters.remaining(), MemoryUtil.memAddress(filters));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteFilters(@NativeType("ALuint *") int filter) {
/* 1171 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1173 */       IntBuffer filters = stack.ints(filter);
/* 1174 */       nalDeleteFilters(1, MemoryUtil.memAddress(filters));
/*      */     } finally {
/* 1176 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalDeleteFiltersDirect(long context, int n, long filters) {
/* 1184 */     long __functionAddress = (AL.getICD()).alDeleteFiltersDirect;
/* 1185 */     if (Checks.CHECKS) {
/* 1186 */       Checks.check(__functionAddress);
/* 1187 */       Checks.check(context);
/*      */     } 
/* 1189 */     JNI.invokePPV(context, n, filters, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteFiltersDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint *") IntBuffer filters) {
/* 1195 */     nalDeleteFiltersDirect(context, filters.remaining(), MemoryUtil.memAddress(filters));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteFiltersDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint *") int filter) {
/* 1201 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1203 */       IntBuffer filters = stack.ints(filter);
/* 1204 */       nalDeleteFiltersDirect(context, 1, MemoryUtil.memAddress(filters));
/*      */     } finally {
/* 1206 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALboolean")
/*      */   public static boolean alIsFilter(@NativeType("ALuint") int filter) {
/* 1215 */     long __functionAddress = (AL.getICD()).alIsFilter;
/* 1216 */     if (Checks.CHECKS) {
/* 1217 */       Checks.check(__functionAddress);
/*      */     }
/* 1219 */     return JNI.invokeZ(filter, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALboolean")
/*      */   public static boolean alIsFilterDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int filter) {
/* 1227 */     long __functionAddress = (AL.getICD()).alIsFilterDirect;
/* 1228 */     if (Checks.CHECKS) {
/* 1229 */       Checks.check(__functionAddress);
/* 1230 */       Checks.check(context);
/*      */     } 
/* 1232 */     return JNI.invokePZ(context, filter, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alFilteri(@NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALint") int value) {
/* 1240 */     long __functionAddress = (AL.getICD()).alFilteri;
/* 1241 */     if (Checks.CHECKS) {
/* 1242 */       Checks.check(__functionAddress);
/*      */     }
/* 1244 */     JNI.invokeV(filter, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alFilteriDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALint") int value) {
/* 1252 */     long __functionAddress = (AL.getICD()).alFilteriDirect;
/* 1253 */     if (Checks.CHECKS) {
/* 1254 */       Checks.check(__functionAddress);
/* 1255 */       Checks.check(context);
/*      */     } 
/* 1257 */     JNI.invokePV(context, filter, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalFilteriv(int filter, int param, long values) {
/* 1264 */     long __functionAddress = (AL.getICD()).alFilteriv;
/* 1265 */     if (Checks.CHECKS) {
/* 1266 */       Checks.check(__functionAddress);
/*      */     }
/* 1268 */     JNI.invokePV(filter, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alFilteriv(@NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALint const *") IntBuffer values) {
/* 1274 */     if (Checks.CHECKS) {
/* 1275 */       Checks.check(values, 1);
/*      */     }
/* 1277 */     nalFilteriv(filter, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalFilterivDirect(long context, int filter, int param, long values) {
/* 1284 */     long __functionAddress = (AL.getICD()).alFilterivDirect;
/* 1285 */     if (Checks.CHECKS) {
/* 1286 */       Checks.check(__functionAddress);
/* 1287 */       Checks.check(context);
/*      */     } 
/* 1289 */     JNI.invokePPV(context, filter, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alFilterivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALint const *") IntBuffer values) {
/* 1295 */     if (Checks.CHECKS) {
/* 1296 */       Checks.check(values, 1);
/*      */     }
/* 1298 */     nalFilterivDirect(context, filter, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alFilterf(@NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALfloat") float value) {
/* 1306 */     long __functionAddress = (AL.getICD()).alFilterf;
/* 1307 */     if (Checks.CHECKS) {
/* 1308 */       Checks.check(__functionAddress);
/*      */     }
/* 1310 */     JNI.invokeV(filter, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alFilterfDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALfloat") float value) {
/* 1318 */     long __functionAddress = (AL.getICD()).alFilterfDirect;
/* 1319 */     if (Checks.CHECKS) {
/* 1320 */       Checks.check(__functionAddress);
/* 1321 */       Checks.check(context);
/*      */     } 
/* 1323 */     JNI.invokePV(context, filter, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalFilterfv(int filter, int param, long values) {
/* 1330 */     long __functionAddress = (AL.getICD()).alFilterfv;
/* 1331 */     if (Checks.CHECKS) {
/* 1332 */       Checks.check(__functionAddress);
/*      */     }
/* 1334 */     JNI.invokePV(filter, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alFilterfv(@NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALfloat const *") FloatBuffer values) {
/* 1340 */     if (Checks.CHECKS) {
/* 1341 */       Checks.check(values, 1);
/*      */     }
/* 1343 */     nalFilterfv(filter, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalFilterfvDirect(long context, int filter, int param, long values) {
/* 1350 */     long __functionAddress = (AL.getICD()).alFilterfvDirect;
/* 1351 */     if (Checks.CHECKS) {
/* 1352 */       Checks.check(__functionAddress);
/* 1353 */       Checks.check(context);
/*      */     } 
/* 1355 */     JNI.invokePPV(context, filter, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alFilterfvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALfloat const *") FloatBuffer values) {
/* 1361 */     if (Checks.CHECKS) {
/* 1362 */       Checks.check(values, 1);
/*      */     }
/* 1364 */     nalFilterfvDirect(context, filter, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetFilteri(int filter, int param, long value) {
/* 1371 */     long __functionAddress = (AL.getICD()).alGetFilteri;
/* 1372 */     if (Checks.CHECKS) {
/* 1373 */       Checks.check(__functionAddress);
/*      */     }
/* 1375 */     JNI.invokePV(filter, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilteri(@NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer value) {
/* 1381 */     if (Checks.CHECKS) {
/* 1382 */       Checks.check(value, 1);
/*      */     }
/* 1384 */     nalGetFilteri(filter, param, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGetFilteri(@NativeType("ALuint") int filter, @NativeType("ALenum") int param) {
/* 1390 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1392 */       IntBuffer value = stack.callocInt(1);
/* 1393 */       nalGetFilteri(filter, param, MemoryUtil.memAddress(value));
/* 1394 */       return value.get(0);
/*      */     } finally {
/* 1396 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetFilteriDirect(long context, int filter, int param, long value) {
/* 1404 */     long __functionAddress = (AL.getICD()).alGetFilteriDirect;
/* 1405 */     if (Checks.CHECKS) {
/* 1406 */       Checks.check(__functionAddress);
/* 1407 */       Checks.check(context);
/*      */     } 
/* 1409 */     JNI.invokePPV(context, filter, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilteriDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer value) {
/* 1415 */     if (Checks.CHECKS) {
/* 1416 */       Checks.check(value, 1);
/*      */     }
/* 1418 */     nalGetFilteriDirect(context, filter, param, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGetFilteriDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int filter, @NativeType("ALenum") int param) {
/* 1424 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1426 */       IntBuffer value = stack.callocInt(1);
/* 1427 */       nalGetFilteriDirect(context, filter, param, MemoryUtil.memAddress(value));
/* 1428 */       return value.get(0);
/*      */     } finally {
/* 1430 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetFilteriv(int filter, int param, long values) {
/* 1438 */     long __functionAddress = (AL.getICD()).alGetFilteriv;
/* 1439 */     if (Checks.CHECKS) {
/* 1440 */       Checks.check(__functionAddress);
/*      */     }
/* 1442 */     JNI.invokePV(filter, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilteriv(@NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer values) {
/* 1448 */     if (Checks.CHECKS) {
/* 1449 */       Checks.check(values, 1);
/*      */     }
/* 1451 */     nalGetFilteriv(filter, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetFilterivDirect(long context, int filter, int param, long values) {
/* 1458 */     long __functionAddress = (AL.getICD()).alGetFilterivDirect;
/* 1459 */     if (Checks.CHECKS) {
/* 1460 */       Checks.check(__functionAddress);
/* 1461 */       Checks.check(context);
/*      */     } 
/* 1463 */     JNI.invokePPV(context, filter, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilterivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer values) {
/* 1469 */     if (Checks.CHECKS) {
/* 1470 */       Checks.check(values, 1);
/*      */     }
/* 1472 */     nalGetFilterivDirect(context, filter, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetFilterf(int filter, int param, long value) {
/* 1479 */     long __functionAddress = (AL.getICD()).alGetFilterf;
/* 1480 */     if (Checks.CHECKS) {
/* 1481 */       Checks.check(__functionAddress);
/*      */     }
/* 1483 */     JNI.invokePV(filter, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilterf(@NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALfloat *") FloatBuffer value) {
/* 1489 */     if (Checks.CHECKS) {
/* 1490 */       Checks.check(value, 1);
/*      */     }
/* 1492 */     nalGetFilterf(filter, param, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static float alGetFilterf(@NativeType("ALuint") int filter, @NativeType("ALenum") int param) {
/* 1498 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1500 */       FloatBuffer value = stack.callocFloat(1);
/* 1501 */       nalGetFilterf(filter, param, MemoryUtil.memAddress(value));
/* 1502 */       return value.get(0);
/*      */     } finally {
/* 1504 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetFilterfDirect(long context, int filter, int param, long value) {
/* 1512 */     long __functionAddress = (AL.getICD()).alGetFilterfDirect;
/* 1513 */     if (Checks.CHECKS) {
/* 1514 */       Checks.check(__functionAddress);
/* 1515 */       Checks.check(context);
/*      */     } 
/* 1517 */     JNI.invokePPV(context, filter, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilterfDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALfloat *") FloatBuffer value) {
/* 1523 */     if (Checks.CHECKS) {
/* 1524 */       Checks.check(value, 1);
/*      */     }
/* 1526 */     nalGetFilterfDirect(context, filter, param, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static float alGetFilterfDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int filter, @NativeType("ALenum") int param) {
/* 1532 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1534 */       FloatBuffer value = stack.callocFloat(1);
/* 1535 */       nalGetFilterfDirect(context, filter, param, MemoryUtil.memAddress(value));
/* 1536 */       return value.get(0);
/*      */     } finally {
/* 1538 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetFilterfv(int filter, int param, long values) {
/* 1546 */     long __functionAddress = (AL.getICD()).alGetFilterfv;
/* 1547 */     if (Checks.CHECKS) {
/* 1548 */       Checks.check(__functionAddress);
/*      */     }
/* 1550 */     JNI.invokePV(filter, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilterfv(@NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALfloat *") FloatBuffer values) {
/* 1556 */     if (Checks.CHECKS) {
/* 1557 */       Checks.check(values, 1);
/*      */     }
/* 1559 */     nalGetFilterfv(filter, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetFilterfvDirect(long context, int filter, int param, long values) {
/* 1566 */     long __functionAddress = (AL.getICD()).alGetFilterfvDirect;
/* 1567 */     if (Checks.CHECKS) {
/* 1568 */       Checks.check(__functionAddress);
/* 1569 */       Checks.check(context);
/*      */     } 
/* 1571 */     JNI.invokePPV(context, filter, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilterfvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALfloat *") FloatBuffer values) {
/* 1577 */     if (Checks.CHECKS) {
/* 1578 */       Checks.check(values, 1);
/*      */     }
/* 1580 */     nalGetFilterfvDirect(context, filter, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGenAuxiliaryEffectSlots(int n, long effectSlots) {
/* 1587 */     long __functionAddress = (AL.getICD()).alGenAuxiliaryEffectSlots;
/* 1588 */     if (Checks.CHECKS) {
/* 1589 */       Checks.check(__functionAddress);
/*      */     }
/* 1591 */     JNI.invokePV(n, effectSlots, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenAuxiliaryEffectSlots(@NativeType("ALuint *") IntBuffer effectSlots) {
/* 1597 */     nalGenAuxiliaryEffectSlots(effectSlots.remaining(), MemoryUtil.memAddress(effectSlots));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGenAuxiliaryEffectSlots() {
/* 1603 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1605 */       IntBuffer effectSlots = stack.callocInt(1);
/* 1606 */       nalGenAuxiliaryEffectSlots(1, MemoryUtil.memAddress(effectSlots));
/* 1607 */       return effectSlots.get(0);
/*      */     } finally {
/* 1609 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGenAuxiliaryEffectSlotsDirect(long context, int n, long effectSlots) {
/* 1617 */     long __functionAddress = (AL.getICD()).alGenAuxiliaryEffectSlotsDirect;
/* 1618 */     if (Checks.CHECKS) {
/* 1619 */       Checks.check(__functionAddress);
/* 1620 */       Checks.check(context);
/*      */     } 
/* 1622 */     JNI.invokePPV(context, n, effectSlots, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenAuxiliaryEffectSlotsDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint *") IntBuffer effectSlots) {
/* 1628 */     nalGenAuxiliaryEffectSlotsDirect(context, effectSlots.remaining(), MemoryUtil.memAddress(effectSlots));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGenAuxiliaryEffectSlotsDirect(@NativeType("ALCcontext *") long context) {
/* 1634 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1636 */       IntBuffer effectSlots = stack.callocInt(1);
/* 1637 */       nalGenAuxiliaryEffectSlotsDirect(context, 1, MemoryUtil.memAddress(effectSlots));
/* 1638 */       return effectSlots.get(0);
/*      */     } finally {
/* 1640 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalDeleteAuxiliaryEffectSlots(int n, long effectSlots) {
/* 1648 */     long __functionAddress = (AL.getICD()).alDeleteAuxiliaryEffectSlots;
/* 1649 */     if (Checks.CHECKS) {
/* 1650 */       Checks.check(__functionAddress);
/*      */     }
/* 1652 */     JNI.invokePV(n, effectSlots, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteAuxiliaryEffectSlots(@NativeType("ALuint *") IntBuffer effectSlots) {
/* 1658 */     nalDeleteAuxiliaryEffectSlots(effectSlots.remaining(), MemoryUtil.memAddress(effectSlots));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteAuxiliaryEffectSlots(@NativeType("ALuint *") int effectSlot) {
/* 1664 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1666 */       IntBuffer effectSlots = stack.ints(effectSlot);
/* 1667 */       nalDeleteAuxiliaryEffectSlots(1, MemoryUtil.memAddress(effectSlots));
/*      */     } finally {
/* 1669 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalDeleteAuxiliaryEffectSlotsDirect(long context, int n, long effectSlots) {
/* 1677 */     long __functionAddress = (AL.getICD()).alDeleteAuxiliaryEffectSlotsDirect;
/* 1678 */     if (Checks.CHECKS) {
/* 1679 */       Checks.check(__functionAddress);
/* 1680 */       Checks.check(context);
/*      */     } 
/* 1682 */     JNI.invokePPV(context, n, effectSlots, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteAuxiliaryEffectSlotsDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint *") IntBuffer effectSlots) {
/* 1688 */     nalDeleteAuxiliaryEffectSlotsDirect(context, effectSlots.remaining(), MemoryUtil.memAddress(effectSlots));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteAuxiliaryEffectSlotsDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint *") int effectSlot) {
/* 1694 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1696 */       IntBuffer effectSlots = stack.ints(effectSlot);
/* 1697 */       nalDeleteAuxiliaryEffectSlotsDirect(context, 1, MemoryUtil.memAddress(effectSlots));
/*      */     } finally {
/* 1699 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALboolean")
/*      */   public static boolean alIsAuxiliaryEffectSlot(@NativeType("ALuint") int effectSlot) {
/* 1708 */     long __functionAddress = (AL.getICD()).alIsAuxiliaryEffectSlot;
/* 1709 */     if (Checks.CHECKS) {
/* 1710 */       Checks.check(__functionAddress);
/*      */     }
/* 1712 */     return JNI.invokeZ(effectSlot, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALboolean")
/*      */   public static boolean alIsAuxiliaryEffectSlotDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effectSlot) {
/* 1720 */     long __functionAddress = (AL.getICD()).alIsAuxiliaryEffectSlotDirect;
/* 1721 */     if (Checks.CHECKS) {
/* 1722 */       Checks.check(__functionAddress);
/* 1723 */       Checks.check(context);
/*      */     } 
/* 1725 */     return JNI.invokePZ(context, effectSlot, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alAuxiliaryEffectSloti(@NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALint") int value) {
/* 1733 */     long __functionAddress = (AL.getICD()).alAuxiliaryEffectSloti;
/* 1734 */     if (Checks.CHECKS) {
/* 1735 */       Checks.check(__functionAddress);
/*      */     }
/* 1737 */     JNI.invokeV(effectSlot, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alAuxiliaryEffectSlotiDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALint") int value) {
/* 1745 */     long __functionAddress = (AL.getICD()).alAuxiliaryEffectSlotiDirect;
/* 1746 */     if (Checks.CHECKS) {
/* 1747 */       Checks.check(__functionAddress);
/* 1748 */       Checks.check(context);
/*      */     } 
/* 1750 */     JNI.invokePV(context, effectSlot, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalAuxiliaryEffectSlotiv(int effectSlot, int param, long values) {
/* 1757 */     long __functionAddress = (AL.getICD()).alAuxiliaryEffectSlotiv;
/* 1758 */     if (Checks.CHECKS) {
/* 1759 */       Checks.check(__functionAddress);
/*      */     }
/* 1761 */     JNI.invokePV(effectSlot, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alAuxiliaryEffectSlotiv(@NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALint const *") IntBuffer values) {
/* 1767 */     if (Checks.CHECKS) {
/* 1768 */       Checks.check(values, 1);
/*      */     }
/* 1770 */     nalAuxiliaryEffectSlotiv(effectSlot, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalAuxiliaryEffectSlotivDirect(long context, int effectSlot, int param, long values) {
/* 1777 */     long __functionAddress = (AL.getICD()).alAuxiliaryEffectSlotivDirect;
/* 1778 */     if (Checks.CHECKS) {
/* 1779 */       Checks.check(__functionAddress);
/* 1780 */       Checks.check(context);
/*      */     } 
/* 1782 */     JNI.invokePPV(context, effectSlot, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alAuxiliaryEffectSlotivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALint const *") IntBuffer values) {
/* 1788 */     if (Checks.CHECKS) {
/* 1789 */       Checks.check(values, 1);
/*      */     }
/* 1791 */     nalAuxiliaryEffectSlotivDirect(context, effectSlot, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alAuxiliaryEffectSlotf(@NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALfloat") float value) {
/* 1799 */     long __functionAddress = (AL.getICD()).alAuxiliaryEffectSlotf;
/* 1800 */     if (Checks.CHECKS) {
/* 1801 */       Checks.check(__functionAddress);
/*      */     }
/* 1803 */     JNI.invokeV(effectSlot, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alAuxiliaryEffectSlotfDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALfloat") float value) {
/* 1811 */     long __functionAddress = (AL.getICD()).alAuxiliaryEffectSlotfDirect;
/* 1812 */     if (Checks.CHECKS) {
/* 1813 */       Checks.check(__functionAddress);
/* 1814 */       Checks.check(context);
/*      */     } 
/* 1816 */     JNI.invokePV(context, effectSlot, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalAuxiliaryEffectSlotfv(int effectSlot, int param, long values) {
/* 1823 */     long __functionAddress = (AL.getICD()).alAuxiliaryEffectSlotfv;
/* 1824 */     if (Checks.CHECKS) {
/* 1825 */       Checks.check(__functionAddress);
/*      */     }
/* 1827 */     JNI.invokePV(effectSlot, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alAuxiliaryEffectSlotfv(@NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALfloat const *") FloatBuffer values) {
/* 1833 */     if (Checks.CHECKS) {
/* 1834 */       Checks.check(values, 1);
/*      */     }
/* 1836 */     nalAuxiliaryEffectSlotfv(effectSlot, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalAuxiliaryEffectSlotfvDirect(long context, int effectSlot, int param, long values) {
/* 1843 */     long __functionAddress = (AL.getICD()).alAuxiliaryEffectSlotfvDirect;
/* 1844 */     if (Checks.CHECKS) {
/* 1845 */       Checks.check(__functionAddress);
/* 1846 */       Checks.check(context);
/*      */     } 
/* 1848 */     JNI.invokePPV(context, effectSlot, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alAuxiliaryEffectSlotfvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALfloat const *") FloatBuffer values) {
/* 1854 */     if (Checks.CHECKS) {
/* 1855 */       Checks.check(values, 1);
/*      */     }
/* 1857 */     nalAuxiliaryEffectSlotfvDirect(context, effectSlot, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetAuxiliaryEffectSloti(int effectSlot, int param, long value) {
/* 1864 */     long __functionAddress = (AL.getICD()).alGetAuxiliaryEffectSloti;
/* 1865 */     if (Checks.CHECKS) {
/* 1866 */       Checks.check(__functionAddress);
/*      */     }
/* 1868 */     JNI.invokePV(effectSlot, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSloti(@NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer value) {
/* 1874 */     if (Checks.CHECKS) {
/* 1875 */       Checks.check(value, 1);
/*      */     }
/* 1877 */     nalGetAuxiliaryEffectSloti(effectSlot, param, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGetAuxiliaryEffectSloti(@NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param) {
/* 1883 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1885 */       IntBuffer value = stack.callocInt(1);
/* 1886 */       nalGetAuxiliaryEffectSloti(effectSlot, param, MemoryUtil.memAddress(value));
/* 1887 */       return value.get(0);
/*      */     } finally {
/* 1889 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetAuxiliaryEffectSlotiDirect(long context, int effectSlot, int param, long value) {
/* 1897 */     long __functionAddress = (AL.getICD()).alGetAuxiliaryEffectSlotiDirect;
/* 1898 */     if (Checks.CHECKS) {
/* 1899 */       Checks.check(__functionAddress);
/* 1900 */       Checks.check(context);
/*      */     } 
/* 1902 */     JNI.invokePPV(context, effectSlot, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSlotiDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer value) {
/* 1908 */     if (Checks.CHECKS) {
/* 1909 */       Checks.check(value, 1);
/*      */     }
/* 1911 */     nalGetAuxiliaryEffectSlotiDirect(context, effectSlot, param, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGetAuxiliaryEffectSlotiDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param) {
/* 1917 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1919 */       IntBuffer value = stack.callocInt(1);
/* 1920 */       nalGetAuxiliaryEffectSlotiDirect(context, effectSlot, param, MemoryUtil.memAddress(value));
/* 1921 */       return value.get(0);
/*      */     } finally {
/* 1923 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetAuxiliaryEffectSlotiv(int effectSlot, int param, long values) {
/* 1931 */     long __functionAddress = (AL.getICD()).alGetAuxiliaryEffectSlotiv;
/* 1932 */     if (Checks.CHECKS) {
/* 1933 */       Checks.check(__functionAddress);
/*      */     }
/* 1935 */     JNI.invokePV(effectSlot, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSlotiv(@NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer values) {
/* 1941 */     if (Checks.CHECKS) {
/* 1942 */       Checks.check(values, 1);
/*      */     }
/* 1944 */     nalGetAuxiliaryEffectSlotiv(effectSlot, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetAuxiliaryEffectSlotivDirect(long context, int effectSlot, int param, long values) {
/* 1951 */     long __functionAddress = (AL.getICD()).alGetAuxiliaryEffectSlotivDirect;
/* 1952 */     if (Checks.CHECKS) {
/* 1953 */       Checks.check(__functionAddress);
/* 1954 */       Checks.check(context);
/*      */     } 
/* 1956 */     JNI.invokePPV(context, effectSlot, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSlotivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer values) {
/* 1962 */     if (Checks.CHECKS) {
/* 1963 */       Checks.check(values, 1);
/*      */     }
/* 1965 */     nalGetAuxiliaryEffectSlotivDirect(context, effectSlot, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetAuxiliaryEffectSlotf(int effectSlot, int param, long value) {
/* 1972 */     long __functionAddress = (AL.getICD()).alGetAuxiliaryEffectSlotf;
/* 1973 */     if (Checks.CHECKS) {
/* 1974 */       Checks.check(__functionAddress);
/*      */     }
/* 1976 */     JNI.invokePV(effectSlot, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSlotf(@NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALfloat *") FloatBuffer value) {
/* 1982 */     if (Checks.CHECKS) {
/* 1983 */       Checks.check(value, 1);
/*      */     }
/* 1985 */     nalGetAuxiliaryEffectSlotf(effectSlot, param, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static float alGetAuxiliaryEffectSlotf(@NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param) {
/* 1991 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1993 */       FloatBuffer value = stack.callocFloat(1);
/* 1994 */       nalGetAuxiliaryEffectSlotf(effectSlot, param, MemoryUtil.memAddress(value));
/* 1995 */       return value.get(0);
/*      */     } finally {
/* 1997 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetAuxiliaryEffectSlotfDirect(long context, int effectSlot, int param, long value) {
/* 2005 */     long __functionAddress = (AL.getICD()).alGetAuxiliaryEffectSlotfDirect;
/* 2006 */     if (Checks.CHECKS) {
/* 2007 */       Checks.check(__functionAddress);
/* 2008 */       Checks.check(context);
/*      */     } 
/* 2010 */     JNI.invokePPV(context, effectSlot, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSlotfDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALfloat *") FloatBuffer value) {
/* 2016 */     if (Checks.CHECKS) {
/* 2017 */       Checks.check(value, 1);
/*      */     }
/* 2019 */     nalGetAuxiliaryEffectSlotfDirect(context, effectSlot, param, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static float alGetAuxiliaryEffectSlotfDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param) {
/* 2025 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2027 */       FloatBuffer value = stack.callocFloat(1);
/* 2028 */       nalGetAuxiliaryEffectSlotfDirect(context, effectSlot, param, MemoryUtil.memAddress(value));
/* 2029 */       return value.get(0);
/*      */     } finally {
/* 2031 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetAuxiliaryEffectSlotfv(int effectSlot, int param, long values) {
/* 2039 */     long __functionAddress = (AL.getICD()).alGetAuxiliaryEffectSlotfv;
/* 2040 */     if (Checks.CHECKS) {
/* 2041 */       Checks.check(__functionAddress);
/*      */     }
/* 2043 */     JNI.invokePV(effectSlot, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSlotfv(@NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALfloat *") FloatBuffer values) {
/* 2049 */     if (Checks.CHECKS) {
/* 2050 */       Checks.check(values, 1);
/*      */     }
/* 2052 */     nalGetAuxiliaryEffectSlotfv(effectSlot, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetAuxiliaryEffectSlotfvDirect(long context, int effectSlot, int param, long values) {
/* 2059 */     long __functionAddress = (AL.getICD()).alGetAuxiliaryEffectSlotfvDirect;
/* 2060 */     if (Checks.CHECKS) {
/* 2061 */       Checks.check(__functionAddress);
/* 2062 */       Checks.check(context);
/*      */     } 
/* 2064 */     JNI.invokePPV(context, effectSlot, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSlotfvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALfloat *") FloatBuffer values) {
/* 2070 */     if (Checks.CHECKS) {
/* 2071 */       Checks.check(values, 1);
/*      */     }
/* 2073 */     nalGetAuxiliaryEffectSlotfvDirect(context, effectSlot, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenEffects(@NativeType("ALuint *") int[] effects) {
/* 2079 */     long __functionAddress = (AL.getICD()).alGenEffects;
/* 2080 */     if (Checks.CHECKS) {
/* 2081 */       Checks.check(__functionAddress);
/*      */     }
/* 2083 */     JNI.invokePV(effects.length, effects, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenEffectsDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint *") int[] effects) {
/* 2089 */     long __functionAddress = (AL.getICD()).alGenEffectsDirect;
/* 2090 */     if (Checks.CHECKS) {
/* 2091 */       Checks.check(__functionAddress);
/* 2092 */       Checks.check(context);
/*      */     } 
/* 2094 */     JNI.invokePPV(context, effects.length, effects, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteEffects(@NativeType("ALuint *") int[] effects) {
/* 2100 */     long __functionAddress = (AL.getICD()).alDeleteEffects;
/* 2101 */     if (Checks.CHECKS) {
/* 2102 */       Checks.check(__functionAddress);
/*      */     }
/* 2104 */     JNI.invokePV(effects.length, effects, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteEffectsDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint *") int[] effects) {
/* 2110 */     long __functionAddress = (AL.getICD()).alDeleteEffectsDirect;
/* 2111 */     if (Checks.CHECKS) {
/* 2112 */       Checks.check(__functionAddress);
/* 2113 */       Checks.check(context);
/*      */     } 
/* 2115 */     JNI.invokePPV(context, effects.length, effects, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alEffectiv(@NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALint const *") int[] values) {
/* 2121 */     long __functionAddress = (AL.getICD()).alEffectiv;
/* 2122 */     if (Checks.CHECKS) {
/* 2123 */       Checks.check(__functionAddress);
/* 2124 */       Checks.check(values, 1);
/*      */     } 
/* 2126 */     JNI.invokePV(effect, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alEffectivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALint const *") int[] values) {
/* 2132 */     long __functionAddress = (AL.getICD()).alEffectivDirect;
/* 2133 */     if (Checks.CHECKS) {
/* 2134 */       Checks.check(__functionAddress);
/* 2135 */       Checks.check(context);
/* 2136 */       Checks.check(values, 1);
/*      */     } 
/* 2138 */     JNI.invokePPV(context, effect, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alEffectfv(@NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALfloat const *") float[] values) {
/* 2144 */     long __functionAddress = (AL.getICD()).alEffectfv;
/* 2145 */     if (Checks.CHECKS) {
/* 2146 */       Checks.check(__functionAddress);
/* 2147 */       Checks.check(values, 1);
/*      */     } 
/* 2149 */     JNI.invokePV(effect, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alEffectfvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALfloat const *") float[] values) {
/* 2155 */     long __functionAddress = (AL.getICD()).alEffectfvDirect;
/* 2156 */     if (Checks.CHECKS) {
/* 2157 */       Checks.check(__functionAddress);
/* 2158 */       Checks.check(context);
/* 2159 */       Checks.check(values, 1);
/*      */     } 
/* 2161 */     JNI.invokePPV(context, effect, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffecti(@NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALint *") int[] value) {
/* 2167 */     long __functionAddress = (AL.getICD()).alGetEffecti;
/* 2168 */     if (Checks.CHECKS) {
/* 2169 */       Checks.check(__functionAddress);
/* 2170 */       Checks.check(value, 1);
/*      */     } 
/* 2172 */     JNI.invokePV(effect, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffectiDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALint *") int[] value) {
/* 2178 */     long __functionAddress = (AL.getICD()).alGetEffectiDirect;
/* 2179 */     if (Checks.CHECKS) {
/* 2180 */       Checks.check(__functionAddress);
/* 2181 */       Checks.check(context);
/* 2182 */       Checks.check(value, 1);
/*      */     } 
/* 2184 */     JNI.invokePPV(context, effect, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffectiv(@NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALint *") int[] values) {
/* 2190 */     long __functionAddress = (AL.getICD()).alGetEffectiv;
/* 2191 */     if (Checks.CHECKS) {
/* 2192 */       Checks.check(__functionAddress);
/* 2193 */       Checks.check(values, 1);
/*      */     } 
/* 2195 */     JNI.invokePV(effect, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffectivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALint *") int[] values) {
/* 2201 */     long __functionAddress = (AL.getICD()).alGetEffectivDirect;
/* 2202 */     if (Checks.CHECKS) {
/* 2203 */       Checks.check(__functionAddress);
/* 2204 */       Checks.check(context);
/* 2205 */       Checks.check(values, 1);
/*      */     } 
/* 2207 */     JNI.invokePPV(context, effect, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffectf(@NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALfloat *") float[] value) {
/* 2213 */     long __functionAddress = (AL.getICD()).alGetEffectf;
/* 2214 */     if (Checks.CHECKS) {
/* 2215 */       Checks.check(__functionAddress);
/* 2216 */       Checks.check(value, 1);
/*      */     } 
/* 2218 */     JNI.invokePV(effect, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffectfDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALfloat *") float[] value) {
/* 2224 */     long __functionAddress = (AL.getICD()).alGetEffectfDirect;
/* 2225 */     if (Checks.CHECKS) {
/* 2226 */       Checks.check(__functionAddress);
/* 2227 */       Checks.check(context);
/* 2228 */       Checks.check(value, 1);
/*      */     } 
/* 2230 */     JNI.invokePPV(context, effect, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffectfv(@NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALfloat *") float[] values) {
/* 2236 */     long __functionAddress = (AL.getICD()).alGetEffectfv;
/* 2237 */     if (Checks.CHECKS) {
/* 2238 */       Checks.check(__functionAddress);
/* 2239 */       Checks.check(values, 1);
/*      */     } 
/* 2241 */     JNI.invokePV(effect, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffectfvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effect, @NativeType("ALenum") int param, @NativeType("ALfloat *") float[] values) {
/* 2247 */     long __functionAddress = (AL.getICD()).alGetEffectfvDirect;
/* 2248 */     if (Checks.CHECKS) {
/* 2249 */       Checks.check(__functionAddress);
/* 2250 */       Checks.check(context);
/* 2251 */       Checks.check(values, 1);
/*      */     } 
/* 2253 */     JNI.invokePPV(context, effect, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenFilters(@NativeType("ALuint *") int[] filters) {
/* 2259 */     long __functionAddress = (AL.getICD()).alGenFilters;
/* 2260 */     if (Checks.CHECKS) {
/* 2261 */       Checks.check(__functionAddress);
/*      */     }
/* 2263 */     JNI.invokePV(filters.length, filters, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenFiltersDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint *") int[] filters) {
/* 2269 */     long __functionAddress = (AL.getICD()).alGenFiltersDirect;
/* 2270 */     if (Checks.CHECKS) {
/* 2271 */       Checks.check(__functionAddress);
/* 2272 */       Checks.check(context);
/*      */     } 
/* 2274 */     JNI.invokePPV(context, filters.length, filters, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteFilters(@NativeType("ALuint *") int[] filters) {
/* 2280 */     long __functionAddress = (AL.getICD()).alDeleteFilters;
/* 2281 */     if (Checks.CHECKS) {
/* 2282 */       Checks.check(__functionAddress);
/*      */     }
/* 2284 */     JNI.invokePV(filters.length, filters, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteFiltersDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint *") int[] filters) {
/* 2290 */     long __functionAddress = (AL.getICD()).alDeleteFiltersDirect;
/* 2291 */     if (Checks.CHECKS) {
/* 2292 */       Checks.check(__functionAddress);
/* 2293 */       Checks.check(context);
/*      */     } 
/* 2295 */     JNI.invokePPV(context, filters.length, filters, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alFilteriv(@NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALint const *") int[] values) {
/* 2301 */     long __functionAddress = (AL.getICD()).alFilteriv;
/* 2302 */     if (Checks.CHECKS) {
/* 2303 */       Checks.check(__functionAddress);
/* 2304 */       Checks.check(values, 1);
/*      */     } 
/* 2306 */     JNI.invokePV(filter, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alFilterivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALint const *") int[] values) {
/* 2312 */     long __functionAddress = (AL.getICD()).alFilterivDirect;
/* 2313 */     if (Checks.CHECKS) {
/* 2314 */       Checks.check(__functionAddress);
/* 2315 */       Checks.check(context);
/* 2316 */       Checks.check(values, 1);
/*      */     } 
/* 2318 */     JNI.invokePPV(context, filter, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alFilterfv(@NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALfloat const *") float[] values) {
/* 2324 */     long __functionAddress = (AL.getICD()).alFilterfv;
/* 2325 */     if (Checks.CHECKS) {
/* 2326 */       Checks.check(__functionAddress);
/* 2327 */       Checks.check(values, 1);
/*      */     } 
/* 2329 */     JNI.invokePV(filter, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alFilterfvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALfloat const *") float[] values) {
/* 2335 */     long __functionAddress = (AL.getICD()).alFilterfvDirect;
/* 2336 */     if (Checks.CHECKS) {
/* 2337 */       Checks.check(__functionAddress);
/* 2338 */       Checks.check(context);
/* 2339 */       Checks.check(values, 1);
/*      */     } 
/* 2341 */     JNI.invokePPV(context, filter, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilteri(@NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALint *") int[] value) {
/* 2347 */     long __functionAddress = (AL.getICD()).alGetFilteri;
/* 2348 */     if (Checks.CHECKS) {
/* 2349 */       Checks.check(__functionAddress);
/* 2350 */       Checks.check(value, 1);
/*      */     } 
/* 2352 */     JNI.invokePV(filter, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilteriDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALint *") int[] value) {
/* 2358 */     long __functionAddress = (AL.getICD()).alGetFilteriDirect;
/* 2359 */     if (Checks.CHECKS) {
/* 2360 */       Checks.check(__functionAddress);
/* 2361 */       Checks.check(context);
/* 2362 */       Checks.check(value, 1);
/*      */     } 
/* 2364 */     JNI.invokePPV(context, filter, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilteriv(@NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALint *") int[] values) {
/* 2370 */     long __functionAddress = (AL.getICD()).alGetFilteriv;
/* 2371 */     if (Checks.CHECKS) {
/* 2372 */       Checks.check(__functionAddress);
/* 2373 */       Checks.check(values, 1);
/*      */     } 
/* 2375 */     JNI.invokePV(filter, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilterivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALint *") int[] values) {
/* 2381 */     long __functionAddress = (AL.getICD()).alGetFilterivDirect;
/* 2382 */     if (Checks.CHECKS) {
/* 2383 */       Checks.check(__functionAddress);
/* 2384 */       Checks.check(context);
/* 2385 */       Checks.check(values, 1);
/*      */     } 
/* 2387 */     JNI.invokePPV(context, filter, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilterf(@NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALfloat *") float[] value) {
/* 2393 */     long __functionAddress = (AL.getICD()).alGetFilterf;
/* 2394 */     if (Checks.CHECKS) {
/* 2395 */       Checks.check(__functionAddress);
/* 2396 */       Checks.check(value, 1);
/*      */     } 
/* 2398 */     JNI.invokePV(filter, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilterfDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALfloat *") float[] value) {
/* 2404 */     long __functionAddress = (AL.getICD()).alGetFilterfDirect;
/* 2405 */     if (Checks.CHECKS) {
/* 2406 */       Checks.check(__functionAddress);
/* 2407 */       Checks.check(context);
/* 2408 */       Checks.check(value, 1);
/*      */     } 
/* 2410 */     JNI.invokePPV(context, filter, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilterfv(@NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALfloat *") float[] values) {
/* 2416 */     long __functionAddress = (AL.getICD()).alGetFilterfv;
/* 2417 */     if (Checks.CHECKS) {
/* 2418 */       Checks.check(__functionAddress);
/* 2419 */       Checks.check(values, 1);
/*      */     } 
/* 2421 */     JNI.invokePV(filter, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilterfvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int filter, @NativeType("ALenum") int param, @NativeType("ALfloat *") float[] values) {
/* 2427 */     long __functionAddress = (AL.getICD()).alGetFilterfvDirect;
/* 2428 */     if (Checks.CHECKS) {
/* 2429 */       Checks.check(__functionAddress);
/* 2430 */       Checks.check(context);
/* 2431 */       Checks.check(values, 1);
/*      */     } 
/* 2433 */     JNI.invokePPV(context, filter, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenAuxiliaryEffectSlots(@NativeType("ALuint *") int[] effectSlots) {
/* 2439 */     long __functionAddress = (AL.getICD()).alGenAuxiliaryEffectSlots;
/* 2440 */     if (Checks.CHECKS) {
/* 2441 */       Checks.check(__functionAddress);
/*      */     }
/* 2443 */     JNI.invokePV(effectSlots.length, effectSlots, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenAuxiliaryEffectSlotsDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint *") int[] effectSlots) {
/* 2449 */     long __functionAddress = (AL.getICD()).alGenAuxiliaryEffectSlotsDirect;
/* 2450 */     if (Checks.CHECKS) {
/* 2451 */       Checks.check(__functionAddress);
/* 2452 */       Checks.check(context);
/*      */     } 
/* 2454 */     JNI.invokePPV(context, effectSlots.length, effectSlots, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteAuxiliaryEffectSlots(@NativeType("ALuint *") int[] effectSlots) {
/* 2460 */     long __functionAddress = (AL.getICD()).alDeleteAuxiliaryEffectSlots;
/* 2461 */     if (Checks.CHECKS) {
/* 2462 */       Checks.check(__functionAddress);
/*      */     }
/* 2464 */     JNI.invokePV(effectSlots.length, effectSlots, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteAuxiliaryEffectSlotsDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint *") int[] effectSlots) {
/* 2470 */     long __functionAddress = (AL.getICD()).alDeleteAuxiliaryEffectSlotsDirect;
/* 2471 */     if (Checks.CHECKS) {
/* 2472 */       Checks.check(__functionAddress);
/* 2473 */       Checks.check(context);
/*      */     } 
/* 2475 */     JNI.invokePPV(context, effectSlots.length, effectSlots, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alAuxiliaryEffectSlotiv(@NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALint const *") int[] values) {
/* 2481 */     long __functionAddress = (AL.getICD()).alAuxiliaryEffectSlotiv;
/* 2482 */     if (Checks.CHECKS) {
/* 2483 */       Checks.check(__functionAddress);
/* 2484 */       Checks.check(values, 1);
/*      */     } 
/* 2486 */     JNI.invokePV(effectSlot, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alAuxiliaryEffectSlotivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALint const *") int[] values) {
/* 2492 */     long __functionAddress = (AL.getICD()).alAuxiliaryEffectSlotivDirect;
/* 2493 */     if (Checks.CHECKS) {
/* 2494 */       Checks.check(__functionAddress);
/* 2495 */       Checks.check(context);
/* 2496 */       Checks.check(values, 1);
/*      */     } 
/* 2498 */     JNI.invokePPV(context, effectSlot, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alAuxiliaryEffectSlotfv(@NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALfloat const *") float[] values) {
/* 2504 */     long __functionAddress = (AL.getICD()).alAuxiliaryEffectSlotfv;
/* 2505 */     if (Checks.CHECKS) {
/* 2506 */       Checks.check(__functionAddress);
/* 2507 */       Checks.check(values, 1);
/*      */     } 
/* 2509 */     JNI.invokePV(effectSlot, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alAuxiliaryEffectSlotfvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALfloat const *") float[] values) {
/* 2515 */     long __functionAddress = (AL.getICD()).alAuxiliaryEffectSlotfvDirect;
/* 2516 */     if (Checks.CHECKS) {
/* 2517 */       Checks.check(__functionAddress);
/* 2518 */       Checks.check(context);
/* 2519 */       Checks.check(values, 1);
/*      */     } 
/* 2521 */     JNI.invokePPV(context, effectSlot, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSloti(@NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALint *") int[] value) {
/* 2527 */     long __functionAddress = (AL.getICD()).alGetAuxiliaryEffectSloti;
/* 2528 */     if (Checks.CHECKS) {
/* 2529 */       Checks.check(__functionAddress);
/* 2530 */       Checks.check(value, 1);
/*      */     } 
/* 2532 */     JNI.invokePV(effectSlot, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSlotiDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALint *") int[] value) {
/* 2538 */     long __functionAddress = (AL.getICD()).alGetAuxiliaryEffectSlotiDirect;
/* 2539 */     if (Checks.CHECKS) {
/* 2540 */       Checks.check(__functionAddress);
/* 2541 */       Checks.check(context);
/* 2542 */       Checks.check(value, 1);
/*      */     } 
/* 2544 */     JNI.invokePPV(context, effectSlot, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSlotiv(@NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALint *") int[] values) {
/* 2550 */     long __functionAddress = (AL.getICD()).alGetAuxiliaryEffectSlotiv;
/* 2551 */     if (Checks.CHECKS) {
/* 2552 */       Checks.check(__functionAddress);
/* 2553 */       Checks.check(values, 1);
/*      */     } 
/* 2555 */     JNI.invokePV(effectSlot, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSlotivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALint *") int[] values) {
/* 2561 */     long __functionAddress = (AL.getICD()).alGetAuxiliaryEffectSlotivDirect;
/* 2562 */     if (Checks.CHECKS) {
/* 2563 */       Checks.check(__functionAddress);
/* 2564 */       Checks.check(context);
/* 2565 */       Checks.check(values, 1);
/*      */     } 
/* 2567 */     JNI.invokePPV(context, effectSlot, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSlotf(@NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALfloat *") float[] value) {
/* 2573 */     long __functionAddress = (AL.getICD()).alGetAuxiliaryEffectSlotf;
/* 2574 */     if (Checks.CHECKS) {
/* 2575 */       Checks.check(__functionAddress);
/* 2576 */       Checks.check(value, 1);
/*      */     } 
/* 2578 */     JNI.invokePV(effectSlot, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSlotfDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALfloat *") float[] value) {
/* 2584 */     long __functionAddress = (AL.getICD()).alGetAuxiliaryEffectSlotfDirect;
/* 2585 */     if (Checks.CHECKS) {
/* 2586 */       Checks.check(__functionAddress);
/* 2587 */       Checks.check(context);
/* 2588 */       Checks.check(value, 1);
/*      */     } 
/* 2590 */     JNI.invokePPV(context, effectSlot, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSlotfv(@NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALfloat *") float[] values) {
/* 2596 */     long __functionAddress = (AL.getICD()).alGetAuxiliaryEffectSlotfv;
/* 2597 */     if (Checks.CHECKS) {
/* 2598 */       Checks.check(__functionAddress);
/* 2599 */       Checks.check(values, 1);
/*      */     } 
/* 2601 */     JNI.invokePV(effectSlot, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSlotfvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int effectSlot, @NativeType("ALenum") int param, @NativeType("ALfloat *") float[] values) {
/* 2607 */     long __functionAddress = (AL.getICD()).alGetAuxiliaryEffectSlotfvDirect;
/* 2608 */     if (Checks.CHECKS) {
/* 2609 */       Checks.check(__functionAddress);
/* 2610 */       Checks.check(context);
/* 2611 */       Checks.check(values, 1);
/*      */     } 
/* 2613 */     JNI.invokePPV(context, effectSlot, param, values, __functionAddress);
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\EXTEfx.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */